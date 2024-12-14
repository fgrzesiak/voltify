package com.example.infrastruktur.application.port.secondary;

import com.example.infrastruktur.application.domain.DomainEvent;

public interface EventPublisher {
	
	public String publishDomainEvent(DomainEvent event);

}
