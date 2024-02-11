package com.example.demo.Product.DTO;


import com.example.demo.Product.Model.Product;
import lombok.Data;

import java.util.Optional;

@Data
public class ProductDto {
    private String name;
    private String description;
    private Double price;

    public ProductDto(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

}
