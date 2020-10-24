package com.talissonmelo.microserviceorder.message;

import com.talissonmelo.microserviceorder.dto.ClientOrderDto;
import com.talissonmelo.microserviceorder.dto.MenuOrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MenuReceiveMessage {

    @RabbitListener(queues = {"${insert.menu.rabbitmq.queu}"})
    public void receiveMessage(@Payload MenuOrderDto menuOrderDto){
        System.out.println(menuOrderDto);
    }
}
