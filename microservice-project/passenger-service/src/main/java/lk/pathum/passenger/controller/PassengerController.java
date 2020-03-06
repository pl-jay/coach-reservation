package lk.pathum.passenger.controller;

import com.netflix.discovery.converters.Auto;
import lk.pathum.passenger.model.Passenger;
import lk.pathum.passenger.service.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerServiceImpl passengerService;

    @RequestMapping("/getAll")
    public List<Passenger> getAll(){
        return passengerService.findAll();
    }


}
