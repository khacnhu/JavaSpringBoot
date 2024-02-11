package com.example.demo.Product.queryHandler;

import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Product.DTO.ProductDto;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Repository.ProductRepository;
import com.example.demo.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductQueryHandler implements Query<Integer, Optional<ProductDto>> {

    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(GetProductQueryHandler.class);

    @Override
    @Cacheable("productCache")
    public ResponseEntity<Optional<ProductDto>> excute(Integer id) {
        logger.info("GetProductQueryHandler in queryHandler file");

        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException();
        } else {
            return ResponseEntity.ok(Optional.of(new ProductDto(product.get())));
        }

    }
}
