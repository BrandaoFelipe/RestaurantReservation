package com.brandao.reserve.dtos.responseDTOs;

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
public class RestaurantTableResponseDTO {

    private Long id;
    private Integer tableNumber;
    private Integer capacity;   
}
