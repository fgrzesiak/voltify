package com.example.lager.application.domain;

import com.example.lager.adapter.secondary.messagequeue.ArtikelTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ArtikelEingetroffenEvent extends DomainEvent {

	public ArtikelEingetroffenEvent(Artikel artikel) {
		ArtikelTO artikelTO = new ArtikelTO(artikel.getId().getId(), artikel.getBestand());
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			this.payload = objectMapper.writeValueAsString(artikelTO);
			
			
			
		} catch (JsonProcessingException e) {
			System.out.println("Message could not be send. Cause: " + e.getMessage());
		}
	}
}
