package lk.pathum.user.controller;

import lk.pathum.user.model.Passenger;
import lk.pathum.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/save")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping("/passenger/{id}")
    public User fetchUser(@PathVariable int id){
        return userService.fetchUser(id);
    }

    @RequestMapping("/sample")
    public User sample(){
        return  new User();
    }
}
