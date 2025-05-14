package com.brandao.reserve.dtos.responseDTOs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationResponseDTO {
    
    private Integer id;
    
    private LocalDateTime beginReservation;

    private LocalDateTime endReservation;

    private Integer numberOfPeople;

    private ClientResponseDTO clientResponseDTO;
    
    @Builder.Default
    private List<RestaurantTableResponseDTO> tables = new ArrayList<>();
}
