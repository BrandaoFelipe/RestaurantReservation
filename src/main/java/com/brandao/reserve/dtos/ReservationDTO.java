package com.brandao.reserve.dtos;

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
public class ReservationDTO {
    
    private Integer id;
    private LocalDateTime dateTime;
    private Integer numberOfPeople;
    private ClientMinDTO clientMinDTO;
    
    @Builder.Default
    private List<RestaurantTableDTO> tables = new ArrayList<>();
}
