package com.example.infrastruktur.adapter.secondary.messagequeue;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.example.infrastruktur.application.domain.DomainEvent;
import com.example.infrastruktur.application.port.secondary.EventPublisher;

public class EventPublisherImpl implements EventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public EventPublisherImpl(RabbitTemplate rabbitTemplate, AmqpAdmin amqpAdmin) {
        this.rabbitTemplate = rabbitTemplate;
        
        // Typischerweise legst du einen neuen Exchange für die 'Ladeinfrastruktur'-Events an
        TopicExchange exchange = new TopicExchange("ladeinfrastruktur.events");
        amqpAdmin.declareExchange(exchange);

        // Neue Queue, z. B. "ladepunktQueue" oder "infrastrukturQueue"
        Queue queue = new Queue("ladepunktQueue", true);
        amqpAdmin.declareQueue(queue);

        // Binding: Queue an den Exchange binden, mit passendem Routing-Key
        amqpAdmin.declareBinding(
            BindingBuilder.bind(queue)
                .to(exchange)
                .with("ladepunkt.aktualisiert")  // oder ähnlich
        );
    }

    @Override
    public String publishDomainEvent(DomainEvent event) {
        // Der Routing Key könnte abhängig vom Event kommen. 
        // Wenn du nur ein Event hast, kannst du es hier direkt auf "ladepunkt.aktualisiert" setzen.
        String routingKey = "ladepunkt.aktualisiert";  
        // Oder z. B. event.getEventName()

        Object response = rabbitTemplate.convertSendAndReceive(
                "ladeinfrastruktur.events",
                routingKey,
                event.getPayload());

        System.out.println("!!!MESSAGE SENT!!!! " + event.getPayload());

        if (response != null) {
            return (String) response;
        }
        return "Response could not be received.";
    }
}
