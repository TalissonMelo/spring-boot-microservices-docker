package com.talissonmelo.insert.configuration;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.AMQP.Exchange;

@Configuration
public class RabbitMQConfiguration {

	@Value("${insert.rabbitmq.exchange}")
	private String exchange;
	
	@Bean
	public Exchange getExchange() {
		return ExchangeBuilder.directExchange(exchange)
					.durable(true)
					.build();
	}
	
	@Bean
	@Autowired
	public RabbitTemplate getTemplate(ConnectionFactory factory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		return rabbitTemplate;
		
	}
}
