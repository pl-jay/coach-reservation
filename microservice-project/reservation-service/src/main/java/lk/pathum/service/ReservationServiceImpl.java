package lk.pathum.service;

import lk.pathum.model.Reservation;
import lk.pathum.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> fetchAll() {
        return reservationRepository.findAll();
    }

    @Override
    /* @Query("select * from Reservation r where ") */
    public List<Reservation> fetchByUser(int id) {
        return null;
    }

    @Override
    public List<Reservation> fetchByCoach(int id) {
        return null;
    }
}
