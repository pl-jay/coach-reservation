package lk.pathum.controller;

import lk.pathum.model.User;
import lk.pathum.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauthController")
public class OAuthController {

    @Autowired
    public UserService userService;

    @RequestMapping("/register")
    public User register(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping("/sample")
    public User sample(){
        return new User();
    }
}
