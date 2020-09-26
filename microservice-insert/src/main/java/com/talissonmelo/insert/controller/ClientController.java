package com.talissonmelo.insert.controller;

import com.talissonmelo.insert.dto.ClientDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @PostMapping(value = "/insert")
    public ClientDto insertClient(@RequestBody  ClientDto clientDto){
        log.info("POST em Client");
       return clientDto;
    }
}
