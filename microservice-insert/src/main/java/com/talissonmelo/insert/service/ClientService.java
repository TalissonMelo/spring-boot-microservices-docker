package com.talissonmelo.insert.service;

import com.talissonmelo.insert.dto.ClientOrderDto;
import com.talissonmelo.insert.entity.Client;
import com.talissonmelo.insert.message.ClientSendMessage;
import com.talissonmelo.insert.repository.ClientRepository;
import com.talissonmelo.insert.service.exception.DataBaseException;
import com.talissonmelo.insert.service.exception.EntityNotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private ClientSendMessage clientSendMessage;

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Client findById(Long id){
        Client client = clientRepository.findById(id)
        		.orElseThrow(() -> new EntityNotFound("Cliente não cadastrado!."));
        clientSendMessage.sendMessage(new ClientOrderDto(client.getId()));
        return client;
    }

    public Client updateClient(Long id ,Client client){
        Client updateClient = findById(id);
        BeanUtils.copyProperties(client, updateClient, "id");
        updateClient = clientRepository.save(updateClient);
        return updateClient;
    }


    public void deleteClient(Long id ){
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFound("Cliente de Id: " + id + ", não encontrado");
        }catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Cliente tem persistência em outra tabela, Deleção não permitida.");
        }
    }
}
