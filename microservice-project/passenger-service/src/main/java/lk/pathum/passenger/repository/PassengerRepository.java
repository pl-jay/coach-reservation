package lk.pathum.passenger.repository;

import lk.pathum.passenger.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
