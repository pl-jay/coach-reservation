package lk.pathum.controller;

import lk.pathum.model.User;
import lk.pathum.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableEurekaClient
@RequestMapping("/oauthController")
public class OAuthController {

    @Autowired
    public UserService userService;

    @GetMapping("/registerNewUser")
    public String AddNewUser(@RequestBody String user){
        return user.toString();
//        return userService.save(user).toString();
    }

}

