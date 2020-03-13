package lk.pathum.utility.controller;

import lk.pathum.utility.model.Utility;
import lk.pathum.utility.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class UtilityController {

    @Autowired
    private UtilityService utilityService;

    @RequestMapping("/getAll")
    public List<Utility> getAll(){
        return utilityService.getAll();
    }

    @RequestMapping("/save")
    public Utility save(@RequestBody Utility utility){
        return utilityService.save(utility);
    }

    @RequestMapping("/passenger/{id}")
    public Utility fetchUtility(@PathVariable int id){
        return null;
    }


    @RequestMapping("/sample")
    public Utility sample(){
        return new Utility();
    }
}
