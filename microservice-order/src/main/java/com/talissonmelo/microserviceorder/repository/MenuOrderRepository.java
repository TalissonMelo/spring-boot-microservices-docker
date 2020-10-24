package com.talissonmelo.microserviceorder.repository;

import com.talissonmelo.microserviceorder.entity.MenuOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuOrderRepository extends JpaRepository<MenuOrder, Long> {
}
