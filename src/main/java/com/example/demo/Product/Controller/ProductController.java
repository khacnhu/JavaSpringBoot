package com.example.demo.Product.Controller;


import com.example.demo.Product.DTO.ProductDto;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.UpdateProductCommand;
import com.example.demo.Product.Repository.ProductRepository;
import com.example.demo.Product.commandHandler.CreateProductCommandHandler;
import com.example.demo.Product.commandHandler.DeleteProductCommandHandler;
import com.example.demo.Product.commandHandler.UpdateProductCommandHandler;
import com.example.demo.Product.queryHandler.GetAllProductHandler;
import com.example.demo.Product.queryHandler.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Create, Read, Update, Delete,
    //Post, Get, Put, Delete

    @Autowired private ProductRepository productRepository;
    @Autowired private GetAllProductHandler getAllProductHandler;
    @Autowired private GetProductQueryHandler getProductQueryHandler;
    @Autowired private CreateProductCommandHandler createProductCommandHandler;
    @Autowired private UpdateProductCommandHandler updateProductCommandHandler;
    @Autowired private DeleteProductCommandHandler deleteProductCommandHandler;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(){
        System.out.println("get Product method");
        return getAllProductHandler.excute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductDto>> getProduct(@PathVariable Integer id) {
        System.out.println("get one product");
        return getProductQueryHandler.excute(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(value = "description") String description ) {
        return ResponseEntity.ok(productRepository.customQueryMethod(description));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        System.out.println("create product successfully");
        return createProductCommandHandler.excute(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        UpdateProductCommand updateProductCommand = new UpdateProductCommand(id, product);
        return updateProductCommandHandler.excute(updateProductCommand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        return deleteProductCommandHandler.excute(id);
    }

//    @ExceptionHandler(ProductNotFoundException. class)
//    public ResponseEntity<String> handleErrorProductNotFoundException() {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
//    }



}
