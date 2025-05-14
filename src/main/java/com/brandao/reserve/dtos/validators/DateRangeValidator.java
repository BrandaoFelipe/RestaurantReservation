package com.brandao.reserve.dtos.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import com.brandao.reserve.dtos.requestsDTO.ReservationRequestDTO;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, ReservationRequestDTO> {
    @Override
    public boolean isValid(ReservationRequestDTO dto, ConstraintValidatorContext context) {
        if (dto.getBeginReservation() == null || dto.getEndReservation() == null) {
            return true; 
        }

        return !dto.getEndReservation().isBefore(dto.getBeginReservation());
    }
}