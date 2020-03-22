package lk.pathum.utility.controller;

import lk.pathum.utility.model.Item;
import lk.pathum.utility.model.Reservation;
import lk.pathum.utility.model.Utility;
import lk.pathum.utility.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilities")
public class UtilityController {

    @Autowired
    private UtilityService utilityService;


//    @PostMapping("/reserve")
//    public Reservation setReservation(@RequestBody Reservation reservation){
//        return reservationService.save(reservation);
//    }
//
//    @GetMapping("/getAll")
//    public List<Reservation> getReservation(){
//        return reservationService.fetchAll();
//    }
//
//    @RequestMapping("/getReservationbyUtility/{id}")
//    public List<Reservation> getReservationbyUtilityId(@PathVariable int id){
//        return reservationService.fetchByUtility(id);
//    }
//
//    @RequestMapping("/getReservationbyUser/{id}")
//    public List<Reservation> getReservationbyUserId(@PathVariable int id){
//        return reservationService.fetchByUser(id);
//    }
//
//    @RequestMapping("/sample")
//    public Reservation sample(){
//        Reservation reservation = new Reservation();
//        return reservation;
//    }

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


    @GetMapping("/sampleUtility")
    public Utility sampleUtility(){
        return new Utility();
    }


    @GetMapping("/utilitySeats/{id}")
    public List<Integer> utilitySeats(@PathVariable int id){
        return utilityService.availableSeats(id);
    }


}
