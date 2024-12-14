package com.example.shop.adapter.primary.messagequeue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.shop.application.port.primary.ShopBetreibenAppService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EventListener {

	ShopBetreibenAppService shopBetreibenAppService;
	
	public EventListener(ShopBetreibenAppService shopBetreibenAppService) {
		this.shopBetreibenAppService = shopBetreibenAppService;
	}
	
	@RabbitListener(queues = "lagerqueue")
    public void receiveMessage(String message) {
        // Process the received message
        System.out.println("#################Received message:################# " + message);
        
        ObjectMapper objectMapper = new ObjectMapper();
        try {
			ArtikelTO artikelTO = objectMapper.readValue(message, ArtikelTO.class);
			shopBetreibenAppService.artikelBestandAktualisieren(artikelTO.getId(), artikelTO.getBestand());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
    }
	 
	 
}
