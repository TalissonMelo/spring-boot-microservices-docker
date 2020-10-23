package com.talissonmelo.microserviceorder.message;

import com.talissonmelo.microserviceorder.dto.ClientOrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClientReceiveMessage {

    @RabbitListener(queues = {"${insert.client.rabbitmq.queue}"})
    public void receiveMessage(@Payload ClientOrderDto clientOrderDto){
        System.out.println(clientOrderDto);
    }
}
