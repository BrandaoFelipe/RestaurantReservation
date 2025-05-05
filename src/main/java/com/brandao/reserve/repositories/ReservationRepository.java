package com.brandao.reserve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandao.reserve.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
