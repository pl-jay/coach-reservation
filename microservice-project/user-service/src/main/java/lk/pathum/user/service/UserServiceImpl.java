package lk.pathum.user.service;

import lk.pathum.user.model.User;
import lk.pathum.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User fetchUser(Integer id) {
        Optional<User> optionalUsr = userRepository.findById(id);
        if(optionalUsr.isPresent()){
            User user = optionalUsr.get();
            return user;
        } else{
            return null;
        }
    }

    @Override
    public User update(Integer id) {
        User user = new User();
        user.setId(id);

        Example<User> example = Example.of(user);
        Optional<User> optionalUsr = userRepository.findOne(example);
        if(optionalUsr.isPresent()){
            User newUser = optionalUsr.get();
            newUser.setName("jaye");
            return userRepository.save(newUser);
        }
        return new User();
    }
}
