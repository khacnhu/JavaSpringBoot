package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ProductNotFoundException. class, ProductNotValidException.class})
    public ResponseEntity<SimpleResponse> handleErrorProductNotFoundException(CustomBaseException customBaseException) {
        return ResponseEntity.status(customBaseException.getStatus()).body(customBaseException.getSimpleResponse());
    }
}
