package com.example.demo.Orders.Controller;

import com.example.demo.Orders.Entity.Order;
import com.example.demo.Orders.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/createOrders")
    private ResponseEntity createOrder() {
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setTotal(Math.random()*100);
        orderRepository.save(order);
        return ResponseEntity.ok().build();
    }

}
