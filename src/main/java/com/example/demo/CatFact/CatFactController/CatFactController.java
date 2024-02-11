package com.example.demo.CatFact.CatFactController;

import com.example.demo.CatFact.DTO.CatFactDTO;
import com.example.demo.CatFact.QueryHandler.CatFactQueryHandler;
import com.example.demo.CatFact.Entity.CatFactEntity;
import com.example.demo.CatFact.Repository.CatFactEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/catfact")
public class CatFactController {

    @Autowired
    private CatFactQueryHandler catFactQueryHandler;

    @Autowired
    private CatFactEntityRepository catFactEntityRepository;

    @GetMapping
    public ResponseEntity<CatFactDTO> getCatFact() {
        return catFactQueryHandler.excute(null);
    }


    @GetMapping("/localCatFactJson")
    public ResponseEntity<?> getSaveCatFactJson() {
        return ResponseEntity.ok(catFactEntityRepository
                .findAll()
                .stream()
                .map(CatFactEntity::convertToCatFact)
                .collect(Collectors.toList()));
    };
}
