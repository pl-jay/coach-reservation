package lk.pathum.reservation.service;

import lk.pathum.reservation.model.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ReservationService {
    Reservation save(Reservation reservation); // new reservation
    List<Reservation> fetchAll();
    List<Reservation> fetchByUser(int id); // fetch by user id
    List<Reservation> fetchByUtility(int id); // fetch by coach id
    boolean cancelReservation(int id);

    Integer[] availableSeats(int id);
    boolean  checkRecord(int id);

    List<Reservation> getReservationsByDate(String date);
}
