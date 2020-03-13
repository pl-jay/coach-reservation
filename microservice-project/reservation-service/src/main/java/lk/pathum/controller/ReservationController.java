package lk.pathum.controller;

import lk.pathum.model.Coach;
import lk.pathum.model.Reservation;
import lk.pathum.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
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

        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setSeatNo(45);
        reservation.setUser(2);
        reservation.setDate(LocalDate.now());

        Reservation reservation2 = new Reservation();
        reservation2.setId(2);
        reservation2.setSeatNo(35);
        reservation2.setUser(3);
        reservation2.setDate(LocalDate.now());
        //reservation2.setCoach();

        Coach coach = new Coach();
        coach.setId(1);
        coach.setNumber("NM-9090");
        coach.setSeats(34);
        coach.setName("lp");
        coach.setAc(true);

        Coach coach2 = new Coach();
        coach.setId(2);
        coach.setNumber("NM-9191");
        coach.setSeats(35);
        coach.setName("OP");
        coach.setAc(true);
        reservation2.setCoach(coach);
        reservation2.setCoach(coach2);
        return reservation;
    }
//
//    @RequestMapping("/coach/{id}")
//    public Coach getCoach(@PathVariable int id){
//        return coachService.fetchByCoach(id);
//    }

}
