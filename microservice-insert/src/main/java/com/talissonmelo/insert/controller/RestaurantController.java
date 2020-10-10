package com.talissonmelo.insert.controller;

import com.talissonmelo.insert.dto.ClientDto;
import com.talissonmelo.insert.dto.RestaurantDto;
import com.talissonmelo.insert.entity.Client;
import com.talissonmelo.insert.entity.Restaurant;
import com.talissonmelo.insert.repository.ClientRepository;
import com.talissonmelo.insert.repository.RestaurantRepository;
import com.talissonmelo.insert.service.ClientService;
import com.talissonmelo.insert.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @Autowired
    private RestaurantRepository repository;

    @PostMapping(value = "/insert")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> insertRestaurant(@RequestBody RestaurantDto restaurantDto){
        log.info("POST em Client");
        Restaurant restaurant = Restaurant.createRestaurant(restaurantDto);
       return ResponseEntity.ok().body(repository.save(restaurant));
    }

    @PutMapping(value = "/{id}/update")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody RestaurantDto restaurantDto){
        Restaurant restaurant = Restaurant.createRestaurant(restaurantDto);
        restaurant = service.updateRestaurant(id,restaurant);
        return ResponseEntity.ok().body(restaurant);
    }

    @DeleteMapping(value = "/{id}/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteById(@PathVariable Long id ){
         service.deleteRestaurant(id);
         return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Restaurant findByRestaurantId(@PathVariable Long id){
        return  service.findById(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Restaurant> findAllRestaurants(){
        return repository.findAll();
    }
}
