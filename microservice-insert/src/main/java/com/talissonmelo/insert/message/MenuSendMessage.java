package com.talissonmelo.insert.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.talissonmelo.insert.dto.MenuOrderDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MenuSendMessage {

	@Value("${insert.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${insert.menu.rabbitmq.routingkey}")
	private String routingKey;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(MenuOrderDto menuOrderDto ) {
		log.info(exchange);
		log.info(routingKey);
		log.info(menuOrderDto.toString());
		rabbitTemplate.convertAndSend(exchange, routingKey , menuOrderDto);
	}
}
