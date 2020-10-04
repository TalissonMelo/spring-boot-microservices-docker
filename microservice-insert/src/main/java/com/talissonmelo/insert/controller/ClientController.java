package com.talissonmelo.insert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/{id}/update")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody ClientDto clientDto){
        Client client = Client.createClient(clientDto);
        client = clientService.updateClient(id,client);
        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping(value = "/{id}/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteById(@PathVariable Long id ){
         clientService.deleteClient(id);
         return ResponseEntity.noContent().build();
    }
}
