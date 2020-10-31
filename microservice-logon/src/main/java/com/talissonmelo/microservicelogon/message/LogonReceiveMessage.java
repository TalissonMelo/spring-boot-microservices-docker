package com.talissonmelo.microservicelogon.message;

import com.talissonmelo.microservicelogon.dto.LogonDto;
import com.talissonmelo.microservicelogon.entity.Logon;
import com.talissonmelo.microservicelogon.repository.LogonRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class LogonReceiveMessage {

    @Autowired
    private LogonRepository logonRepository;

    @RabbitListener(queues = {"${insert.logon.rabbitmq.queu}"})
    public void receiveMessage(@Payload LogonDto logonDto){
        logonRepository.save(new Logon(null,logonDto.getEmail() , logonDto.getPassword()));
    }
}
