package lk.pathum.coach.controller;

import lk.pathum.coach.model.Coach;
import lk.pathum.coach.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @RequestMapping("/getAll")
    public List<Coach> getAll(){
        return coachService.getAll();
    }

    @RequestMapping("/save")
    public Coach save(@RequestBody Coach coach){
        return coachService.save(coach);
    }

    @RequestMapping("/passenger/{id}")
    public Coach fetchCoach(@PathVariable int id){
        return null;
    }


    @RequestMapping("/sample")
    public Coach sample(){
        return new Coach();
    }
}
