package com.example.demo;

import org.springframework.http.ResponseEntity;

public interface Query<I, O> {
    ResponseEntity<O> excute(I Input);
}
