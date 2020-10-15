package com.talissonmelo.microserviceorder.repository;

import com.talissonmelo.microserviceorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Long> {
}
