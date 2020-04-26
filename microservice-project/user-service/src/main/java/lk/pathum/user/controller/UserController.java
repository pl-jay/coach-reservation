package lk.pathum.user.controller;

import lk.pathum.user.model.UserModel;
import lk.pathum.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAll")
    public List<UserModel> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/save")
    public UserModel save(@RequestBody UserModel user){
        return userService.save(user);
    }

    @RequestMapping("/user/{id}")
    public UserModel fetchUser(@PathVariable int id){
        return userService.fetchUser(id);
    }

    @RequestMapping("/sample")
    public UserModel sample(){
        return  new UserModel();
    }

    @RequestMapping("/sampleUpdate/{id}")
    public UserModel sampleUpdate(@PathVariable int id){
        return  userService.update(id);
    }

}
