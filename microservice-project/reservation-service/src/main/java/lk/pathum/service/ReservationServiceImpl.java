package lk.pathum.service;

import lk.pathum.model.Reservation;
import lk.pathum.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    @Transactional
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> fetchAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> fetchByUser(int id) {
        Reservation reservation = new Reservation();
        reservation.setUser(id);
        return reservationRepository.findAll(Example.of(reservation));
    }

    @Override
    public List<Reservation> fetchByUtility(int id) {
        Reservation reservation = new Reservation();
        reservation.setUtility_id(id);
        return reservationRepository.findAll(Example.of(reservation));
    }

    @Override
    public Integer[] availableSeats(int id) {

        Reservation reservation = new Reservation();
        reservation.setUtility_id(id);

        List<Integer> list2 = new ArrayList<>();

        Example<Reservation> reservationExample = Example.of(reservation);
        List<Reservation> reservationOptional = reservationRepository.findAll(reservationExample);

        for (Reservation res: reservationOptional) {
            list2.add(res.getSeatNo());
        }

        return list2.stream().toArray(Integer[]::new);
    }


}
