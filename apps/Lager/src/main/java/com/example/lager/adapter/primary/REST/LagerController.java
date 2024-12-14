package com.example.lager.adapter.primary.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lager.application.port.primary.LagerVerwaltenAppService;

@RestController
public class LagerController {
	
	LagerVerwaltenAppService lagerVerwaltenAppService;
	
	public LagerController(LagerVerwaltenAppService lagerVerwaltenAppService) {
		this.lagerVerwaltenAppService = lagerVerwaltenAppService;
	}
	
	@GetMapping("/bestandAnzeigen/{id}")
    public ResponseEntity<String> bestandAnzeigen(@PathVariable("id") int id) {
		
		int bestand = lagerVerwaltenAppService.bestandErmitteln(id);
		
		String responseBody;
	    HttpStatus responseCode; 
	         
		if (bestand == -1) {
			responseBody = "Artikel nicht gefunden";
			responseCode = HttpStatus.NOT_FOUND;
		}
			
        else {
			responseBody = String.valueOf(bestand);
			responseCode = HttpStatus.OK;
        }
        
        return new ResponseEntity<>(responseBody, responseCode);
					
	}
	
	
	
	
	@PutMapping("/artikelEinlagern/{id}/{menge}")
    public ResponseEntity<String> artikelEinlagern(@PathVariable("id") int id, @PathVariable("menge") int menge) {

				
		String responseBody;
	    HttpStatus responseCode; 
	     
	    int erg = lagerVerwaltenAppService.artkelEinlagern(id, menge);
	        
		if (erg == -1) {
			responseBody = "Artikel nicht gefunden";
			responseCode = HttpStatus.NOT_FOUND;
		}
			
       else {
			responseBody = "Artikel eingelagert";
			responseCode = HttpStatus.OK;
       }
       
       return new ResponseEntity<>(responseBody, responseCode);
		
	    
	}
	
	
}

