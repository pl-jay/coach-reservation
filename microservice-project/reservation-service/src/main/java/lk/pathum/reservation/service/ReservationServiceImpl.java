package lk.pathum.reservation.service;

import lk.pathum.reservation.model.Reservation;
import lk.pathum.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    @Transactional
    public Reservation save(Reservation reservation) {
        reservation.setReserved(true);
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
    public boolean cancelReservation(int id) {
        try{
            reservationRepository.deleteById(id);
            return checkRecord(id);
        } catch (Exception e){
            return checkRecord(id);
        }

    }

    @Override
    public Integer[] availableSeats(int id) {

        Reservation reservation = new Reservation();
        reservation.setUtility_id(id);

        List<Integer> list2 = new ArrayList<>();
        List<Reservation> reservationOptional = reservationRepository.findAll(Example.of(reservation));

        for (Reservation res: reservationOptional) {
            list2.add(res.getSeatNo());
        }

        return list2.stream().toArray(Integer[]::new);
    }

    @Override
    public boolean checkRecord(int id){
        return reservationRepository.findById(id).isPresent();
    }

    @Override
    public List<Reservation> getReservationsByDate(String date) {
        Reservation reservation = new Reservation();
        reservation.setDate(date);
        return reservationRepository.findAll(Example.of(reservation));
    }


}
