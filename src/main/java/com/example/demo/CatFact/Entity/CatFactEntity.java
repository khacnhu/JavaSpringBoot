package com.example.demo.CatFact.Entity;


import com.example.demo.CatFact.DTO.CatFact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cat_fact")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CatFactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "catFactJson")
    private String catFactJson;

    public CatFactEntity(CatFact catFact) {
        this.catFactJson = convertToJson(catFact);
    }

    //SERIALIZATION
    private String convertToJson (CatFact catFact) {
        System.out.println("check chay conver k");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("check " + objectMapper.writeValueAsString(catFact));
            return objectMapper.writeValueAsString(catFact);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    //DESERIALIZATION
    public CatFact convertToCatFact() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(catFactJson, CatFact.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
