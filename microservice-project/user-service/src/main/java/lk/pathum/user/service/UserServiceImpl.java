package lk.pathum.user.service;

import lk.pathum.user.OauthCommand.OAuthCommand;
import lk.pathum.user.model.User;
import lk.pathum.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() { return new RestTemplate(); }

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public String saveUser(User user) {
        try {
            return new OAuthCommand(user,restTemplate, new HttpHeaders()).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        saveUser(user);
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
