package com.brandao.reserve.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brandao.reserve.dtos.ReservationDTO;
import com.brandao.reserve.entities.Reservation;
import com.brandao.reserve.entities.RestaurantTable;
import com.brandao.reserve.entities.TableReservation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReservationMapper {

    @Autowired
    private final RestaurantTableMapper tableMapper;
    @Autowired
    private final ClientMinMapper clientMinMapper;

    public ReservationDTO toDTO(Reservation entity) {
        if (entity == null)
            return null;

        return ReservationDTO.builder()
                .id(entity.getId())
                .dateTime(entity.getDateTime())
                .numberOfPeople(entity.getNumberOfPeople())
                .clientMinDTO(clientMinMapper.toDTO(entity.getClient()))
                .tables(tableMapper.getTablesDTO(entity.getReservations()))
                .build();
    }

    public Reservation toEntity(ReservationDTO dto) {
        if (dto == null)
            return null;

        Reservation reservation = Reservation.builder()
                .dateTime(dto.getDateTime())
                .numberOfPeople(dto.getNumberOfPeople())
                .build();

        List<TableReservation> tableReservations = dto.getTables()
                .stream()
                .map(tableDTO -> {
                    RestaurantTable table = tableMapper.toEntity(tableDTO);
                    return TableReservation.builder()
                            .reservation(reservation)
                            .restaurantTable(table)
                            .build();
                })
                .collect(Collectors.toList());

        reservation.setReservations(tableReservations);
        return reservation;
    }

}
