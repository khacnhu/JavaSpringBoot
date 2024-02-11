package com.example.demo.Product.commandHandler;


import com.example.demo.Command;
import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductCommandHandler implements Command<Integer, ResponseEntity> {

    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(DeleteProductCommandHandler.class);

    @Override
    public ResponseEntity<ResponseEntity> excute(Integer id) {
        logger.info("DeleteProductCommandHandler in command Handler");

        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Product productFil = productRepository.findById(id).get();
        productRepository.delete(productFil);
        return ResponseEntity.ok().build();
    }
}
