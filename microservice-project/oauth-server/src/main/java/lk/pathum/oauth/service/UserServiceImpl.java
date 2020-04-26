package lk.pathum.oauth.service;

import antlr.BaseAST;
import lk.pathum.oauth.model.Role;
import lk.pathum.oauth.model.User;
import lk.pathum.oauth.repository.RoleRepository;
import lk.pathum.oauth.repository.UserRepository;
import lk.pathum.oauth.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(String user_name,String email, String password,String role) {
        User tempUser = new User();
        Role u_role = new Role();
        Role newRole = null;
        List<Role> roleList = new ArrayList<>();

        tempUser.setEmail(email);
        Optional<User> userOptional = userRepository.findOne(Example.of(tempUser));

        u_role.setName(role);
        Optional<Role> roleOptional = roleRepository.findOne(Example.of(u_role));

        if(roleOptional.isEmpty()) {
            newRole = roleRepository.save(u_role);
        }

        if(roleOptional.isPresent()){
            roleList.add(roleOptional.get());
        } else {
            roleList.add(newRole);
        }

        tempUser.setRoles(roleList);

        if(userOptional.isEmpty()){
            tempUser.setUsername(user_name);
            tempUser.setPassword(bCryptPasswordEncoder.encode(password));
            tempUser.setEnabled(true);
            return userRepository.save(tempUser);
        } else {
            return new User();
        }

    }

    @Override
    public User findById(Integer id) {
        Optional<User> usr = userRepository.findById(id);
        return usr.orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}