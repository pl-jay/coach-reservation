package lk.pathum.passenger.service;

import lk.pathum.passenger.model.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> getAll();
    Passenger save(Passenger passenger);
    Passenger fetchPassenger(Integer id);
}
