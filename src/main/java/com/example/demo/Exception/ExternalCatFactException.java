package com.example.demo.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;


public class ExternalCatFactException extends CustomBaseException{
    public ExternalCatFactException(String message) {
        super(HttpStatus.SERVICE_UNAVAILABLE, new SimpleResponse(message));
    }

}
