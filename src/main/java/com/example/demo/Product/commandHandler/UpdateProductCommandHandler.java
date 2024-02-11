package com.example.demo.Product.commandHandler;

import com.example.demo.Command;
import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.UpdateProductCommand;
import com.example.demo.Product.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.ConsoleHandler;

@Service
public class UpdateProductCommandHandler implements Command<UpdateProductCommand, ResponseEntity<?>> {

    @Autowired
    private ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(UpdateProductCommandHandler.class);

    @Override
//    @CacheEvict(value = "productCache", key = "#command.getId()")
    public ResponseEntity<ResponseEntity<?>> excute(UpdateProductCommand updateProductCommand) {
        logger.info("UpdateProductCommandHandler in command Handler");

        Optional<Product> optionalProduct = productRepository.findById(updateProductCommand.getId());
        System.out.println("check " + optionalProduct);

        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Product product = updateProductCommand.getProduct();
        product.setId(updateProductCommand.getId());
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}
