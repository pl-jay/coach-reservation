package lk.pathum.service;

import lk.pathum.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    Reservation save(Reservation reservation); // new reservation
    List<Reservation> fetchAll();
    List<Reservation> fetchByUser(int id); // fetch by user id
    List<Reservation> fetchByCoach(int id); // fetch by coach id
}
