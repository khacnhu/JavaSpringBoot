package com.example.demo.Product.Repository;

import com.example.demo.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//            WHERE p.description LIKE %:description%"

    // Query write our own SQL statement
    @Query("SELECT p from Product p WHERE p.description LIKE %:description%")
    List<Product> customQueryMethod(@Param(value = "description") String description);

    // Spring Data JPA to have spring generate it for us
//    List<Product> findByDescriptionContent(String keyword);


}
