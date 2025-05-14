package com.brandao.reserve.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brandao.reserve.entities.RestaurantTable;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long>{

    @Query(nativeQuery = true, value = "SELECT * FROM TB_RESTAURANT_TABLE AS TB WHERE TB.TABLE_NUMBER IN (:tableNumber)" )
    public List<RestaurantTable> getTable(@Param("tableNumber") List<Integer> tableNumber);

}
