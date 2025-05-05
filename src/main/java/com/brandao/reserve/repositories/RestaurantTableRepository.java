package com.brandao.reserve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandao.reserve.entities.RestaurantTable;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long>{

}
