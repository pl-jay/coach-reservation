package lk.pathum.passenger.controller;

import lk.pathum.passenger.model.Passenger;
import lk.pathum.passenger.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @RequestMapping("/getAll")
    public List<Passenger> getAll(){
        return passengerService.getAll();
    }

    @RequestMapping("/save")
    public Passenger save(@RequestBody Passenger passenger){
        return passengerService.save(passenger);
    }

    @RequestMapping("/passenger/{id}")
    public Passenger fetchPassenger(@PathVariable int id){
        return passengerService.fetchPassenger(id);
    }

    @RequestMapping("/sample")
    public Passenger sample(){
        return  new Passenger();
    }
}
