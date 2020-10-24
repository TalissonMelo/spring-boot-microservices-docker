package com.talissonmelo.microserviceorder.repository;

import com.talissonmelo.microserviceorder.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderRepository  extends JpaRepository<ClientOrder, Long> {
}
