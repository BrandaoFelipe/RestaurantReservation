package com.brandao.reserve.dtos;

import com.brandao.reserve.dtos.responseDTOs.ReservationResponseDTO;
import com.brandao.reserve.dtos.responseDTOs.RestaurantTableResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TableReservationDTO {

    private Long id;   
    private ReservationResponseDTO reservationDTO;
    private RestaurantTableResponseDTO restaurantTableDTO;
}
