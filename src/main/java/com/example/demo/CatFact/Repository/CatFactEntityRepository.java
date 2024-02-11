package com.example.demo.CatFact.Repository;

import com.example.demo.CatFact.Entity.CatFactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatFactEntityRepository extends JpaRepository<CatFactEntity, Integer> {

}
