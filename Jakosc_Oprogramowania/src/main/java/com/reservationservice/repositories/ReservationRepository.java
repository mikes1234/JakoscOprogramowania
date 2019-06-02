package com.reservationservice.repositories;


import com.reservationservice.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

}
