package com.brandao.reserve.services.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String e) {
        super(e);
    }

}