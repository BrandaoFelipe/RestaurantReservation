package com.brandao.reserve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandao.reserve.entities.TableReservation;

public interface TableReservationRepository extends JpaRepository<TableReservation, Long>{

}
