package com.example.demo.Headers.Controller;

import com.example.demo.Product.Model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HeaderController {

//    @GetMapping("/headers")
//    public String getRegionalRequest(@RequestHeader(required = false, defaultValue = "USA") String region) {
//        if(region.contains("USA")) return "REGION HAS USA";
//
//        if(region.contains("CAN")) return "REGION HAS CANADA";
//
//        return "Country not support in headers";
//    }

//    @GetMapping(value = "/headers", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<Product> getProduct() {
//        Product product = new Product();
//        product.setName("My Product adfadfasdfa");
//        product.setDescription("meu ta new p");
//        return ResponseEntity.ok(product);
//    }

}
