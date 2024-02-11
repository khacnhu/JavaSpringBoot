package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends CustomBaseException{

    public ProductNotFoundException() {
        super(HttpStatus.NOT_FOUND, new SimpleResponse("Product khong tim thay trong data base"));
    }
}
