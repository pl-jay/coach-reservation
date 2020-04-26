package lk.pathum.oauth.controller;

import lk.pathum.oauth.model.User;
import lk.pathum.oauth.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableEurekaClient
public class OAuthController {

    @Autowired
    public UserService userService;

    @GetMapping("/registerNewUserG/{name}/{email}/{password}/{role}")
    public String AddNewUserG(@PathVariable String name,@PathVariable String email,@PathVariable String password,@PathVariable String role){
        System.out.println(email+ "___"+name+"__"+password +"___"+role);
        return userService.save(name,email,password,role).toString();
    }

}

