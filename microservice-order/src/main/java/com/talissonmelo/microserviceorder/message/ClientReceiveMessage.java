package com.talissonmelo.microserviceorder.message;

import com.talissonmelo.microserviceorder.dto.ClientOrderDto;
import com.talissonmelo.microserviceorder.entity.ClientOrder;
import com.talissonmelo.microserviceorder.repository.ClientOrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientReceiveMessage {

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @RabbitListener(queues = {"${insert.client.rabbitmq.queue}"})
    public void receiveMessage(@Payload ClientOrderDto clientOrderDto){
        clientOrderRepository.save(new ClientOrder(null, clientOrderDto.getIdClient()));
    }
}
