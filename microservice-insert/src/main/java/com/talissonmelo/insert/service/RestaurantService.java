package com.talissonmelo.insert.service;

import com.talissonmelo.insert.entity.Restaurant;
import com.talissonmelo.insert.repository.RestaurantRepository;
import com.talissonmelo.insert.service.exception.DataBaseException;
import com.talissonmelo.insert.service.exception.EntityNotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public Restaurant save(Restaurant restaurant){
        return repository.save(restaurant);
    }

    public Restaurant findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFound("Restaurante não cadastrado!."));
    }

    public Restaurant updateRestaurant(Long id ,Restaurant restaurant){
        Restaurant updateRestaurant = findById(id);
        BeanUtils.copyProperties(restaurant, updateRestaurant, "id");
        updateRestaurant = repository.save(updateRestaurant);
        return updateRestaurant;
    }

    public void deleteRestaurant(Long id ){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFound("Restaurante de Id: " + id + ", não encontrado");
        }catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Restaurante tem persistência em outra tabela, Deleção não permitida.");
        }
    }
}
