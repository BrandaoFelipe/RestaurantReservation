package com.brandao.reserve.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brandao.reserve.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

    @Query(nativeQuery = true, value = "SELECT COUNT(*) > 0 FROM TB_RESERVATION r JOIN TB_RESERVATION_TABLE rt ON r.id = rt.reservation_id WHERE rt.restaurant_table_id IN (:tableIds) AND (:bookingDateTime = r.date_time)")
    public boolean isTableReserved(@Param ("tableIds") List<Long>tableIds, @Param("bookingDateTime") LocalDateTime bookingDateTime);
}
