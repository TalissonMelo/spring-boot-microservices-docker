package com.talissonmelo.insert.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.talissonmelo.insert.dto.MenuDto;
import com.talissonmelo.insert.entity.Menu;
import com.talissonmelo.insert.entity.Restaurant;
import com.talissonmelo.insert.repository.MenuRepository;
import com.talissonmelo.insert.service.exception.DataBaseException;
import com.talissonmelo.insert.service.exception.EntityNotFound;

@Service
public class MenuService {

    @Autowired
    private MenuRepository repository;

    @Autowired
    private RestaurantService restaurantService;

    public Menu save(MenuDto menuDto){

        Restaurant restaurant = restaurantService.findById(menuDto.getRestaurant());
        Menu menu = Menu.createMenu(menuDto);
        menu.setRestaurant(restaurant);
        return repository.save(menu);
    }

    public Menu findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFound("Cardápio não cadastrado!."));
    }

    public Menu updateMenu(Long id ,MenuDto menuDto){
        Menu updateMenu = findById(id);
        Restaurant restaurant = restaurantService.findById(menuDto.getRestaurant());
        BeanUtils.copyProperties(menuDto, updateMenu , "id");
        updateMenu.setRestaurant(restaurant);
        updateMenu = repository.save(updateMenu);
        return updateMenu;
    }


    public void deleteMenu(Long id ){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFound("Cardápio de Id: " + id + ", não encontrado");
        }catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Cardápio tem persistência em outra tabela, Deleção não permitida.");
        }
    }
}
