package com.example.demo.Controller;

import com.example.demo.DTO.OrderRequest;
import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Order;
import com.example.demo.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

 private final OrderService orderservice;


   @PostMapping
    public ResponseEntity<Order> createCustomer(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderservice.createOrder(orderRequest));
    }
}
