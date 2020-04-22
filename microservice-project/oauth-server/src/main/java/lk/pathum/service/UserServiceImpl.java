package lk.pathum.service;

import lk.pathum.model.Role;
import lk.pathum.model.User;
import lk.pathum.repository.RoleRepository;
import lk.pathum.repository.UserRepository;
import lk.pathum.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User save(User user) {
        User tempUser = new User();
        tempUser.setEmail(user.getEmail());
        tempUser.setUsername(user.getUsername());
        Optional<User> userOptional = userRepository.findOne(Example.of(tempUser));

        if(userOptional.isEmpty()){
            List<Role> role = user.getRoles();
            user.setRoles(role);
            return userRepository.save(user);
        }
        return userOptional.get();
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