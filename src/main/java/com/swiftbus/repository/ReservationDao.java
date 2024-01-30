package com.swiftbus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiftbus.model.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer> {

}
