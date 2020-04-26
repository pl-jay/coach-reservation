package lk.pathum.utility.controller;

import lk.pathum.utility.model.FilteredUtilities;
import lk.pathum.utility.service.UtilityService;
import lk.pathum.utility.model.CoachRoutes;
import lk.pathum.utility.model.Utility;
import lk.pathum.utility.service.UtilityRoutesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/utilities")
public class UtilityController {

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private UtilityRoutesService routesService;

    // utility requests mapping
    @GetMapping("/getAllUtilities")
    public List<Utility> getAllUtilities(){
        return utilityService.getAll();
    }

    @PostMapping("/saveUtility")
    public Utility saveUtility(@RequestBody Utility utility){
        return utilityService.save(utility);
    }

    @GetMapping("/utility/{id}")
    public Utility fetchUtilitybyId(@PathVariable int id){
        return utilityService.fetchUtility(id);
    }

    @GetMapping("/sampleUtility/{id}")
    public Integer sampleUtility(@PathVariable int id){
        return utilityService.seats(id);
    }

    @GetMapping("/utilitySeats/{id}")
    public List<Integer> utilitySeats(@PathVariable int id){
        return utilityService.availableSeats(id);
    }

    @GetMapping("/utilityRoutes")
    public List<CoachRoutes> utilityRoutes(){
        return routesService.getAllRoutes();
    }

    @GetMapping("/filteredUtilities")
    public List<Utility> getFilteredUtilities(@RequestBody FilteredUtilities filteredUtilities) { return utilityService.utilityFilter(filteredUtilities);}


}
