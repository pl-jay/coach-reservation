package lk.pathum.user.service;

import lk.pathum.user.OauthCommand.OAuthCommand;
import lk.pathum.user.repository.UserRepository;
import lk.pathum.user.model.UserModel;
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
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    public String saveUser(UserModel user) {
        try {
            return new OAuthCommand(user,restTemplate, new HttpHeaders()).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
    @Override
    public UserModel save(UserModel user) {
        UserModel newUser = new UserModel();
        newUser.setEmail(user.getEmail());
        Example<UserModel> modelExample = Example.of(newUser);
        Optional<UserModel> optionalUserModel = userRepository.findOne(modelExample);

        if(optionalUserModel.isEmpty()){
            saveUser(user);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        return new UserModel();
    }

    @Override
    public UserModel fetchUser(Integer id) {
        Optional<UserModel> optionalUsr = userRepository.findById(id);
        if(optionalUsr.isPresent()){
            UserModel user = optionalUsr.get();
            return user;
        } else{
            return null;
        }
    }

    @Override
    public UserModel update(Integer id) {
        UserModel user = new UserModel();
        user.setId(id);
        Example<UserModel> example = Example.of(user);
        Optional<UserModel> optionalUsr = userRepository.findOne(example);
        if(optionalUsr.isPresent()){
            UserModel newUser = optionalUsr.get();
            newUser.setName("jaye");
            return userRepository.save(newUser);
        }
        return new UserModel();
    }
}
