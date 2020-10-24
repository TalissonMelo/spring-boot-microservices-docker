package com.talissonmelo.microserviceorder.message;

import com.talissonmelo.microserviceorder.dto.ClientOrderDto;
import com.talissonmelo.microserviceorder.dto.MenuOrderDto;
import com.talissonmelo.microserviceorder.entity.MenuOrder;
import com.talissonmelo.microserviceorder.repository.MenuOrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MenuReceiveMessage {

    @Autowired
    private MenuOrderRepository menuOrderRepository;

    @RabbitListener(queues = {"${insert.menu.rabbitmq.queu}"})
    public void receiveMessage(@Payload MenuOrderDto menuOrderDto){
        menuOrderRepository.save(new MenuOrder(null, menuOrderDto.getIdMenu(), menuOrderDto.getIdRestaurant()));
    }
}
