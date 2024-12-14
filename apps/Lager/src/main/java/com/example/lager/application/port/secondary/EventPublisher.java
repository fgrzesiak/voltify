package com.example.lager.application.port.secondary;

import com.example.lager.application.domain.DomainEvent;

public interface EventPublisher {
	
	public String publishDomainEvent(DomainEvent event);

}
