package com.talissonmelo.insert.service;

import com.talissonmelo.insert.entity.Client;
import com.talissonmelo.insert.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client){
        return clientRepository.save(client);
    }
}
