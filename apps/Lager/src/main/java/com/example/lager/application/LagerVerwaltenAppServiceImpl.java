package com.example.lager.application;

import com.example.lager.application.domain.Artikel;
import com.example.lager.application.domain.ArtikelEinlagernDomainService;
import com.example.lager.application.domain.ArtikelId;
import com.example.lager.application.port.primary.LagerVerwaltenAppService;
import com.example.lager.application.port.secondary.ArtikelRepository;

public class LagerVerwaltenAppServiceImpl implements LagerVerwaltenAppService {
	
	
	ArtikelRepository artikelRepository;
	ArtikelEinlagernDomainService artikelEinlagernDomainService;
	
	public LagerVerwaltenAppServiceImpl(ArtikelRepository artikelRepository, ArtikelEinlagernDomainService artikelEinlagernDomainService) {
		this.artikelRepository = artikelRepository;
		this.artikelEinlagernDomainService = artikelEinlagernDomainService;
	}
	
	@Override
	public int artkelEinlagern(int id, int menge) {
		
		Artikel artikel = artikelRepository.findArtikelById(new ArtikelId(id));
		
		if (artikel == null)
		  	return -1;
		  	
		artikelEinlagernDomainService.aktualisiereBestand(artikel,menge);
		artikelRepository.save(artikel);
		
		return 0;
    	
	 
	}
	
	 public int bestandErmitteln(int id) {
			
			Artikel artikel = artikelRepository.findArtikelById(new ArtikelId(id));
			
			
			if (artikel == null)
			  	return -1;
			  	
			
	    	return artikel.getBestand();   
	    	
			
		    
		}
	 
	 

}
