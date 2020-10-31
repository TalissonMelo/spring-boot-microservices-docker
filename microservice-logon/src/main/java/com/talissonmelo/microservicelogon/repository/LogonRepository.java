package com.talissonmelo.microservicelogon.repository;

import com.talissonmelo.microservicelogon.entity.Logon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogonRepository extends JpaRepository<Logon, Long> {
}
