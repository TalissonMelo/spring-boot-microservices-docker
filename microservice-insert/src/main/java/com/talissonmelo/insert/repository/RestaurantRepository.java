package com.talissonmelo.insert.repository;

import com.talissonmelo.insert.entity.Client;
import com.talissonmelo.insert.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
