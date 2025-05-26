package com.brandao.reserve.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brandao.reserve.dtos.CustomError;
import com.brandao.reserve.services.exceptions.EmptyResultException;
import com.brandao.reserve.services.exceptions.EntityNotAvailableException;
import com.brandao.reserve.services.exceptions.InvalidRequestException;
import com.brandao.reserve.services.exceptions.NotAllawedException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

     @ExceptionHandler(EntityNotAvailableException.class)
    public ResponseEntity<CustomError> resourceNotAvailable(EntityNotAvailableException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.CONFLICT;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmptyResultException.class)
    public ResponseEntity<CustomError> resourceNotFound(EmptyResultException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<CustomError> InvalidRequest(InvalidRequestException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError>  handleValidationErrors(MethodArgumentNotValidException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NotAllawedException.class)
    public ResponseEntity<CustomError>  notAllawedExeption(NotAllawedException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }


}
