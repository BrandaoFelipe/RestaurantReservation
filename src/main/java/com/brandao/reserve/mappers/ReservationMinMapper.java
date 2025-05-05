package com.brandao.reserve.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.ReservationMinimalDTO;
import com.brandao.reserve.entities.Reservation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReservationMinMapper {

    @Autowired
    private final RestaurantTableMapper tableMapper;   

    public ReservationMinimalDTO toMinDTO (Reservation entity){
        if (entity == null) return null;

        return ReservationMinimalDTO.builder()
        .id(entity.getId())
        .dateTime(entity.getDateTime())
        .numberOfPeople(entity.getNumberOfPeople())        
        .tables(tableMapper.getTablesDTO(entity.getReservations()))
        .build();
    }
    
}
