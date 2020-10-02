package com.talissonmelo.insert.service;

import com.talissonmelo.insert.entity.Client;
import com.talissonmelo.insert.repository.ClientRepository;
import com.talissonmelo.insert.service.exception.EntityNotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Client findById(Long id){
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFound("Cliente não cadastrado!."));
    }

    public Client updateClient(Client client){
        Client updateClient = findById(client.getId());
        BeanUtils.copyProperties(client, updateClient, "id");
        updateClient = clientRepository.save(updateClient);
        return updateClient;
    }
}
