package com.brandao.reserve.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.requestsDTO.ReservationRequestDTO;
import com.brandao.reserve.dtos.responseDTOs.ReservationResponseDTO;
import com.brandao.reserve.entities.Reservation;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReservationMapper {

    @Autowired
    private final RestaurantTableMapper tableMapper;

    @Autowired
    private final ClientMapper clientMapper;

    public ReservationResponseDTO toDTO(Reservation entity) {
        if (entity == null)
            return null;

        return ReservationResponseDTO.builder()
                .id(entity.getId())
                .beginReservation(entity.getBeginReservation())
                .endReservation(entity.getEndReservation())
                .numberOfPeople(entity.getNumberOfPeople())
                .clientResponseDTO(clientMapper.toDTO(entity.getClient()))
                .tables(tableMapper.getTablesDTO(entity.getReservations()))
                .build();
    }

    public Reservation toEntity(ReservationRequestDTO dto) {
        if (dto == null)
            return null;

        Reservation reservation = Reservation.builder()
                .beginReservation(dto.getBeginReservation())
                .endReservation(dto.getEndReservation())                
                .numberOfPeople(dto.getNumberOfPeople())
                .build();
        
        return reservation;
    }



}
