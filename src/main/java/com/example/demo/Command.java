package com.example.demo;

import org.springframework.http.ResponseEntity;

public interface Command<E, T> {
    /**
     * @param entity entities for blandness
     * @return  ResponseEntity<T>
     */
    ResponseEntity<T> excute(E entity);
}
