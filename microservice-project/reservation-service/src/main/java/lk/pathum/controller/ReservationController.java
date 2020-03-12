package lk.pathum.controller;

import lk.pathum.model.Reservation;
import lk.pathum.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @RequestMapping("/reserve")
    public Reservation reservation(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @RequestMapping("/getAll")
    public List<Reservation> getAll(){
        return reservationService.fetchAll();
    }

    @RequestMapping("/sample")
    public Reservation sample(){
        return new Reservation();
    }

}
