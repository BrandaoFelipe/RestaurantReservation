package com.brandao.reserve.mappers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.ClientDTO;
import com.brandao.reserve.dtos.ReservationMinimalDTO;
import com.brandao.reserve.entities.Client;
import com.brandao.reserve.entities.Reservation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientMapper {    
   
    @Autowired
    private final ReservationMinMapper reservationMinMapper;

    public ClientDTO toDTO(Client entity){
        if (entity == null) return null;

        return ClientDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .email(entity.getEmail())
        .phoneNumber(entity.getPhoneNumber())
        .reservations(mapReservations(entity.getReservations()))
        .build();
    }

    public Client toEntity(ClientDTO dto){
        if(dto == null) return null;

        return Client.builder()
        .id(dto.getId())
        .name(dto.getName())
        .email(dto.getEmail())
        .phoneNumber(dto.getPhoneNumber())
        .build();
    }

    private List<ReservationMinimalDTO> mapReservations(List<Reservation> reservations) {
        if (reservations == null || reservations.isEmpty()) {
            return Collections.emptyList();
        }
        
        return reservations.stream()
                .map(reservationMinMapper::toMinDTO) 
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    
}
