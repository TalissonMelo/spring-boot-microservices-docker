package com.talissonmelo.insert.repository;

import com.talissonmelo.insert.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
