package com.example.lager.adapter.secondary.springboot;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.lager.adapter.primary.REST.LagerController;
import com.example.lager.adapter.secondary.messagequeue.EventPublisherImpl;
import com.example.lager.adapter.secondary.persistence.ArtikelRepositoryImplDb;
import com.example.lager.adapter.secondary.persistence.JdbcArtikelEntityRepository;
import com.example.lager.application.LagerVerwaltenAppServiceImpl;
import com.example.lager.application.domain.ArtikelEinlagernDomainService;
import com.example.lager.application.port.primary.LagerVerwaltenAppService;
import com.example.lager.application.port.secondary.ArtikelRepository;
import com.example.lager.application.port.secondary.EventPublisher;


@Configuration
public class BeanConfiguration {

	
	@Bean
	 LagerController lagerController(LagerVerwaltenAppService lagerVerwaltenAppService) {
	        return new LagerController(lagerVerwaltenAppService);
	 }
	
	@Bean
	 LagerVerwaltenAppService lagerVerwaltenAppService(ArtikelRepository artikelRepository, ArtikelEinlagernDomainService artikelEinlagernDomainService) {
	        return new LagerVerwaltenAppServiceImpl(artikelRepository, artikelEinlagernDomainService);
	 }
	
	 
	@Bean
	ArtikelEinlagernDomainService artikelEinlagernDomainService(EventPublisher eventPublisher) {
		return new ArtikelEinlagernDomainService(eventPublisher);
		
	}
	
	@Bean
	 ArtikelRepository artikelRepository(JdbcArtikelEntityRepository jdbcArtikelEntityRepository) {
	        return new ArtikelRepositoryImplDb(jdbcArtikelEntityRepository);
	 }
	
	@Bean
	EventPublisher eventPublisher(RabbitTemplate rabbitTemplate, AmqpAdmin amqpAdmin) {
		return new EventPublisherImpl (rabbitTemplate, amqpAdmin);
	}
	
	
	 
}
