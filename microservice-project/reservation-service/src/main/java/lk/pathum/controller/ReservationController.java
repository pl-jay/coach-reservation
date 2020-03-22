package lk.pathum.controller;

import lk.pathum.model.Reservation;
import lk.pathum.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservationController")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping("/reserve")
    public Reservation setReservation(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @GetMapping("/getAll")
    public List<Reservation> getReservation(){
        return reservationService.fetchAll();
    }

    @RequestMapping("/getReservationbyUtility/{id}")
    public List<Reservation> getReservationbyUtilityId(@PathVariable int id){
        return reservationService.fetchByUtility(id);
    }

    @RequestMapping("/getReservationbyUser/{id}")
    public List<Reservation> getReservationbyUserId(@PathVariable int id){
        return reservationService.fetchByUser(id);
    }

    @RequestMapping("/sample")
    public Reservation sample(){
        Reservation reservation = new Reservation();
        return reservation;
    }

    @RequestMapping("/seats/{id}")
    public Integer[] Test(@PathVariable int id){
        return reservationService.availableSeats(id);
    }

}
