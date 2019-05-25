package com.reservationservice.services;

import com.reservationservice.entities.Reservation;
import com.reservationservice.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImplementation implements ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public void setReservationRepository(ReservationRepository reservationRepository) { this.reservationRepository = reservationRepository; }

    @Override
    public Iterable<Reservation> listAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Integer id) {
        return reservationRepository.findOne(id);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) { return reservationRepository.save(reservation); }

    @Override
    public void deleteReservation(Integer id) {
        reservationRepository.delete(id);
    }

}
