package com.example.lager.application.domain;

import com.example.lager.application.port.secondary.EventPublisher;
public class ArtikelEinlagernDomainService {
	
	
	private EventPublisher eventPublisher;
	
	
	public ArtikelEinlagernDomainService(EventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
	
	
	public boolean aktualisiereBestand (Artikel artikel, int menge) {
		
		// Hier ggf. noch Prüfungen, ob der Lagerplatz reicht
		
		artikel.einlagern(menge);
		
		DomainEvent artikelEingetroffenEvent= new ArtikelEingetroffenEvent(artikel);
		eventPublisher.publishDomainEvent(artikelEingetroffenEvent);
		
		return true;
		
		
		
	}

}
