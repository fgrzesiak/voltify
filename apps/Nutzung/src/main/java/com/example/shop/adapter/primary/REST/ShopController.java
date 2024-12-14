package com.example.shop.adapter.primary.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.application.port.primary.ShopBetreibenAppService;

@RestController
public class ShopController {
	
	ShopBetreibenAppService shopBetreibenAppService;
	
	public ShopController(ShopBetreibenAppService shopBetreibenAppService) {
		this.shopBetreibenAppService = shopBetreibenAppService;
	}
	
	@GetMapping("/bestandAnzeigen/{id}")
   public ResponseEntity<String> bestandAnzeigen(@PathVariable("id") int id) {
	
		String bewertung = shopBetreibenAppService.bestandBewertungErmitteln(id);
		     
			
		String responseBody;
	    HttpStatus responseCode; 
	         
		if (bewertung == null) {
			responseBody = "Artikel nicht gefunden";
			responseCode = HttpStatus.NOT_FOUND;
		}
			
	    else {
			responseBody = bewertung;
			responseCode = HttpStatus.OK;
	    }
	    
	    return new ResponseEntity<>(responseBody, responseCode);
						
		}
	
}
