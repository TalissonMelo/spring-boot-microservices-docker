package com.talissonmelo.insert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.insert.dto.ClientDto;
import com.talissonmelo.insert.entity.Client;
import com.talissonmelo.insert.service.ClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/insert")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> insertClient(@RequestBody  ClientDto clientDto){
        log.info("POST em Client");
        Client client = Client.createClient(clientDto);
       return ResponseEntity.ok().body(clientService.save(client));
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody ClientDto clientDto){
        Client client = Client.createClient(clientDto);
        client = clientService.updateClient(client);
        return ResponseEntity.ok().body(client);
    }
}
