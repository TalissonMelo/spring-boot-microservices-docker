package com.talissonmelo.microserviceorder.service;

import com.talissonmelo.microserviceorder.entity.Order;
import com.talissonmelo.microserviceorder.repository.OrderRepository;
import com.talissonmelo.microserviceorder.service.exception.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order insert(Order order){
        return repository.save(order);
    }

    public Order findById(Long id){
        return repository.findById(id).orElseThrow( () -> new EntityNotFound("Pedido nao encontrado!."));
    }
}
