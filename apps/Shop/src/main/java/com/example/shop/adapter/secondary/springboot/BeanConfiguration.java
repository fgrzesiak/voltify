package com.example.shop.adapter.secondary.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.shop.adapter.primary.REST.ShopController;
import com.example.shop.adapter.primary.messagequeue.EventListener;
import com.example.shop.adapter.secondary.persistence.ArtikelRepositoryImplDb;
import com.example.shop.adapter.secondary.persistence.JdbcArtikelEntityRepository;
import com.example.shop.application.ShopBetreibenAppServiceImpl;
import com.example.shop.application.port.primary.ShopBetreibenAppService;
import com.example.shop.application.port.secondary.ArtikelRepository;

@Configuration
public class BeanConfiguration {
	@Bean
	ArtikelRepository artikelRepository(JdbcArtikelEntityRepository jdbcArtikelEntityRepository) {
	        return new ArtikelRepositoryImplDb(jdbcArtikelEntityRepository);
	 }

	
	@Bean
	ShopBetreibenAppService shopBetreibenAppService(ArtikelRepository artikelRepository) {
	        return new ShopBetreibenAppServiceImpl(artikelRepository);
	 }
	
	@Bean
	ShopController shopController(ShopBetreibenAppService shopBetreibenAppService) {
	        return new ShopController(shopBetreibenAppService);
	 }
	
	
	@Bean
	EventListener eventListener(ShopBetreibenAppService shopBetreibenAppService) {	
		return new EventListener(shopBetreibenAppService);
	}
	
	 
	
	 
}
