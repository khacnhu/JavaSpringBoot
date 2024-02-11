package com.example.demo.Product.queryHandler;


import com.example.demo.Product.DTO.ProductDto;
import com.example.demo.Product.Repository.ProductRepository;
import com.example.demo.Product.commandHandler.CreateProductCommandHandler;
import com.example.demo.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductHandler implements Query<Void, List<ProductDto>> {

    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(GetAllProductHandler.class);

    @Override
    public ResponseEntity<List<ProductDto>> excute(Void product) {
        logger.info("GetAllProductHandler in queryHandler file");
        List<ProductDto> productDtos = productRepository
                .findAll()
                .stream()
                .map(ProductDto::new)
                .toList();
        return ResponseEntity.ok(productDtos);
    }
}
