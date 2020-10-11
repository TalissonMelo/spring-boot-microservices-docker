package com.talissonmelo.insert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.insert.dto.MenuDto;
import com.talissonmelo.insert.entity.Menu;
import com.talissonmelo.insert.repository.MenuRepository;
import com.talissonmelo.insert.service.MenuService;

@RestController
@RequestMapping(value = "/menus")
public class MenuController {

    @Autowired
    private MenuService service;

    @Autowired
    private MenuRepository repository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> insertClient(@RequestBody MenuDto menuDto){
       return ResponseEntity.ok().body(service.save(menuDto));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody MenuDto menuDto){
        Menu menu = service.updateMenu(id,menuDto);
        return ResponseEntity.ok().body(menu);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteById(@PathVariable Long id ){
         service.deleteMenu(id);
         return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Menu findByClientId(@PathVariable Long id){
        return  service.findById(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Menu> findAllClients(){
        return repository.findAll();
    }
}
