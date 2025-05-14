package com.brandao.reserve.dtos.requestsDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
public class RestaurantTableRequestDTO {

    @NotBlank(message = "the table must have a number")
    private Integer tableNumber;

    @Positive
    @Min(value = 2, message = "minimum of 2 people")
    @Max(value = 8, message = "maximum of 8 people")
    private Integer capacity;   
}
