package com.talissonmelo.insert.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.talissonmelo.insert.dto.ClientOrderDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientSendMessage {

	@Value("${insert.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${insert.client.rabbitmq.routingkey}")
	private String routingKey;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(ClientOrderDto clientOrderDto ) {
		log.info(exchange);
		log.info(routingKey);
		log.info(clientOrderDto.toString());
		rabbitTemplate.convertAndSend(exchange, routingKey , clientOrderDto);
	}
}
