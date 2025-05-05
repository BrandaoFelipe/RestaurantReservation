package com.brandao.reserve.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.ReservationDTO;
import com.brandao.reserve.entities.Reservation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReservationMapper {

    @Autowired
    private final RestaurantTableMapper tableMapper;

    @Autowired
    private final ClientMinMapper clientMinMapper;

    public ReservationDTO toDTO (Reservation entity){
        if (entity == null) return null;

        return ReservationDTO.builder()
        .id(entity.getId())
        .dateTime(entity.getDateTime())
        .numberOfPeople(entity.getNumberOfPeople())
        .clientMinDTO(clientMinMapper.toDTO(entity.getClient()))        
        .tables(tableMapper.getTablesDTO(entity.getReservations()))
        .build();
    }
    
}
