package com.example.lager.application.domain;

public class DomainEvent {
	
	
	protected String payload;
	
	
	
	public DomainEvent() {}
	
	public DomainEvent(String payload) {
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}
	
	
	
}
