package lk.pathum.reservation.controller;

import lk.pathum.reservation.model.Reservation;
import lk.pathum.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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


    @PostMapping("/cancelReservation/{id}")
    public boolean cancelReservation(@PathVariable int id) {
        return reservationService.cancelReservation(id);
    }

    @RequestMapping("/sample")
    public Reservation sample(){
        Reservation reservation = new Reservation();
        return reservation;
    }

    @GetMapping("/getReservationsByDate/{date}")
    public List<Reservation> getReservationsByDate(@PathVariable String date) {
        return reservationService.getReservationsByDate(date);
    }

    @RequestMapping("/seats/{id}")
    public Integer[] Test(@PathVariable int id){
        return reservationService.availableSeats(id);
    }

}
