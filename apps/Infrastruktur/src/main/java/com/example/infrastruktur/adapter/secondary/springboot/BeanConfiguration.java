package com.example.infrastruktur.adapter.secondary.springboot;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.infrastruktur.adapter.primary.REST.LadepunktController;
import com.example.infrastruktur.adapter.secondary.messagequeue.EventPublisherImpl;
import com.example.infrastruktur.adapter.secondary.persistence.LadepunktRepositoryImplDb;
import com.example.infrastruktur.adapter.secondary.persistence.JdbcLadepunktEntityRepository;
import com.example.infrastruktur.application.domain.LadepunktDomainService;
import com.example.infrastruktur.application.port.primary.LadeinfrastrukturVerwaltungsAppService;
import com.example.infrastruktur.application.LadeinfrastrukturVerwaltungsAppServiceImpl;
import com.example.infrastruktur.application.port.secondary.LadepunktRepository;
import com.example.infrastruktur.application.port.secondary.EventPublisher;
import com.example.infrastruktur.application.port.secondary.GrundstueckseigentuemerRepository;

@Configuration
public class BeanConfiguration {

    /**
     * Controller-Bean (analog zu LagerController, aber jetzt: LadepunktController)
     */
    @Bean
    LadepunktController ladepunktController(LadeinfrastrukturVerwaltungsAppService ladeinfraService) {
        return new LadepunktController(ladeinfraService);
    }

    /**
     * Application-Service-Bean (ersetzt LagerVerwaltenAppService durch LadeinfrastrukturVerwaltungsAppService)
     */
    @Bean
    LadeinfrastrukturVerwaltungsAppService ladeinfrastrukturVerwaltungsAppService(
            LadepunktRepository ladepunktRepository,
			GrundstueckseigentuemerRepository eigentuemerRepository,
            LadepunktDomainService ladepunktDomainService) {
        return new LadeinfrastrukturVerwaltungsAppServiceImpl(ladepunktRepository, eigentuemerRepository, ladepunktDomainService);
    }

    /**
     * Domain-Service-Bean (analog zum ArtikelEinlagernDomainService – jetzt für Ladevorgänge oder Wartung o. ä.)
     */
    @Bean
    LadepunktDomainService ladepunktDomainService(EventPublisher eventPublisher) {
        return new LadepunktDomainService(eventPublisher);
    }

    /**
     * Repository-Bean (ersetzt ArtikelRepository durch LadepunktRepository).
     * Implementierung = LadepunktRepositoryImplDb, das wiederum JdbcLadepunktEntityRepository nutzt.
     */
    @Bean
    LadepunktRepository ladepunktRepository(JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository) {
        return new LadepunktRepositoryImplDb(jdbcLadepunktEntityRepository);
    }

    /**
     * EventPublisher-Bean (RabbitMQ / AMQP), analog zum EventPublisherImpl im Artikel-Beispiel.
     */
    @Bean
    EventPublisher eventPublisher(RabbitTemplate rabbitTemplate, AmqpAdmin amqpAdmin) {
        return new EventPublisherImpl(rabbitTemplate, amqpAdmin);
    }

}