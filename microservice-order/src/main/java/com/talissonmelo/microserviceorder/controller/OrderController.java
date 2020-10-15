package com.talissonmelo.microserviceorder.controller;

import com.talissonmelo.microserviceorder.dto.OrderDto;
import com.talissonmelo.microserviceorder.entity.Order;
import com.talissonmelo.microserviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody  OrderDto orderDto){
        Order order = Order.createOrder(orderDto);
        return ResponseEntity.ok().body(service.insert(order));
    }
}
