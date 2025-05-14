package com.brandao.reserve.dtos.requestsDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.brandao.reserve.dtos.validators.ValidDateRange;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
@ValidDateRange //[makes sure endReservation is greater than beginReservation]
public class ReservationRequestDTO {
    
    @Future(message = "The date must be future")    
    private LocalDateTime beginReservation;

    @Future(message = "The date must be future")   
    private LocalDateTime endReservation;

    @Positive
    @Min(value = 1, message = "There must be at least on person")
    private Integer numberOfPeople;

    @NotNull
    private String clientCpf;
    
    @Builder.Default
    private List<Integer> tableNumbers = new ArrayList<>();
}
