package com.example.lager.adapter.secondary.messagequeue;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


import com.example.lager.application.domain.DomainEvent;
import com.example.lager.application.port.secondary.EventPublisher;

public class EventPublisherImpl implements EventPublisher{
	
	private RabbitTemplate rabbitTemplate;
   
   
	public EventPublisherImpl (RabbitTemplate rabbitTemplate, AmqpAdmin amqpAdmin) {
		this.rabbitTemplate = rabbitTemplate;
		
		TopicExchange exchange = new TopicExchange("lager.events");
        amqpAdmin.declareExchange(exchange);
        
        Queue queue = new Queue("lagerqueue", true);
		amqpAdmin.declareQueue(queue);
		
		amqpAdmin.declareBinding(BindingBuilder.bind(queue).to(new TopicExchange("lager.events")).with("artikel.eingetroffen"));
		}

	@Override
	public String publishDomainEvent(DomainEvent event) {
		Object response = rabbitTemplate.convertSendAndReceive(
				"lager.events", 
				"artikel.eingetroffen",
				event.getPayload());
		
		System.out.println("!!!MESSAGE SENT!!!! "+event.getPayload() );
		
		if (response != null) {
			return (String) response;
		}
		return "Response could not be received.";
		// TODO Auto-generated method stub
		
	}
   
    
}
