package com.brandao.reserve.dtos;

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
public class RestaurantTableDTO {

    private Long id;
    private Integer number;
    private Integer capacity;
}
