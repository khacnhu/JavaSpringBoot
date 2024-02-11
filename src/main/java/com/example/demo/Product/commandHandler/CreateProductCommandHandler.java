package com.example.demo.Product.commandHandler;

import com.example.demo.Command;
import com.example.demo.Exception.ProductNotValidException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Repository.ProductRepository;
import com.example.demo.Product.queryHandler.GetProductQueryHandler;
import com.mysql.cj.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductCommandHandler implements Command<Product, ResponseEntity<?>> {
    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(CreateProductCommandHandler.class);

    @Override
    public ResponseEntity<ResponseEntity<?>> excute(Product product) {
        logger.info("CreateProductCommandHandler in command Hanlder");
        validateProduct(product);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    private void validateProduct(Product product) {
        if(StringUtils.isNullOrEmpty(product.getName())) {
            logger.error("getName error in command Hanlder");
            throw new ProductNotValidException("name should required");
        }


        if(StringUtils.isNullOrEmpty(product.getDescription())) {
            logger.error("description error in command Hanlder");
            throw new ProductNotValidException("description should required");
        }

        if(product.getPrice() < 0) {
            logger.error("price error in command Hanlder");
            throw new ProductNotValidException("price should > 0");
        }

        if(product.getQuantity() < 0) {
            logger.error("getQuantity error in command Hanlder");
            throw new ProductNotValidException("price should > 0");
        }
    }

}
