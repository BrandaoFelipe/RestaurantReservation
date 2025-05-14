package com.brandao.reserve.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brandao.reserve.entities.Client;
import com.brandao.reserve.entities.Reservation;
import com.brandao.reserve.entities.RestaurantTable;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(nativeQuery = true, value = "SELECT EXISTS( SELECT 1 FROM TB_RESERVATION r JOIN TB_TABLE_RESERVATION rt ON r.id = rt.reservation_id WHERE rt.restaurant_table_id IN (:tableNumber) AND (r.end_reservation > :beginReservation  AND r.begin_reservation < :endReservation ))")
    public boolean isTableReserved(@Param("tableNumber") List<Integer> tableNumber,
            @Param("beginReservation") LocalDateTime beginReservation,
            @Param("endReservation") LocalDateTime endReservation);

    @Query(nativeQuery = true, value = "SELECT RES.ID AS RESERVATION_ID, RES.BEGIN_RESERVATION, RES.END_RESERVATION, RES.NUMBER_OF_PEOPLE, RES.CLIENT_ID, CLI.ID, CLI.NAME, CLI.CPF, CLI.EMAIL, CLI.PHONE_NUMBER FROM TB_RESERVATION AS RES INNER JOIN TB_CLIENT AS CLI ON RES.CLIENT_ID = CLI.ID WHERE CLI.CPF = :cpf")
    public List<Reservation> reservationByClientCpf(@Param("cpf") String cpf);


    @Query(nativeQuery = true, value = "SELECT * FROM TB_CLIENT CLI WHERE CLI.CPF = :cpf" )
    public Client getClient(@Param("cpf") String cpf);

    
    @Query(nativeQuery = true, value = "SELECT * FROM TB_RESTAURANT_TABLE AS TB WHERE TB.TABLE_NUMBER IN (:tableNumber)" )
    public List<RestaurantTable> getTable(@Param("tableNumber") List<Integer> tableNumber);



}
