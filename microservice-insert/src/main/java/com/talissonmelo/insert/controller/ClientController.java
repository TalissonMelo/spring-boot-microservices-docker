package com.talissonmelo.insert.controller;

import com.talissonmelo.insert.dto.ClientDto;
import com.talissonmelo.insert.entity.Client;
import com.talissonmelo.insert.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/insert")
    public ResponseEntity<?> insertClient(@RequestBody  ClientDto clientDto){
        log.info("POST em Client");
        Client client = Client.createClient(clientDto);
       return ResponseEntity.ok().body(clientService.save(client));
    }
}
