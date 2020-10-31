package com.talissonmelo.insert.message;

import com.talissonmelo.insert.dto.ClientOrderDto;
import com.talissonmelo.insert.dto.LogonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogonSendMessage {

	@Value("${insert.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${insert.logon.rabbitmq.routingkey}")
	private String routingKey;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(LogonDto logonDto ) {
		log.info(exchange);
		log.info(routingKey);
		log.info(logonDto.toString());
		rabbitTemplate.convertAndSend(exchange, routingKey , logonDto);
	}
}
