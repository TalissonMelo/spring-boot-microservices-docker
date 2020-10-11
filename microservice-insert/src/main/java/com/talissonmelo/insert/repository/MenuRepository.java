package com.talissonmelo.insert.repository;

import com.talissonmelo.insert.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
