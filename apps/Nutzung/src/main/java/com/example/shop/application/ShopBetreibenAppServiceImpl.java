package com.example.shop.application;

import com.example.shop.application.domain.Artikel;
import com.example.shop.application.domain.ArtikelId;
import com.example.shop.application.port.primary.ShopBetreibenAppService;
import com.example.shop.application.port.secondary.ArtikelRepository;

public class ShopBetreibenAppServiceImpl implements ShopBetreibenAppService {
	
	
	ArtikelRepository artikelRepository;
	
	public ShopBetreibenAppServiceImpl(ArtikelRepository artikelRepository) {
		this.artikelRepository = artikelRepository;
	}
	
    public String bestandBewertungErmitteln(int id) {
		
		Artikel artikel = artikelRepository.findArtikelById(new ArtikelId(id));
		
		
		if (artikel == null)
		  	return null;
		  	
    	String bewertung = artikel.bewerteBestand();
    	return bewertung;   
    	
		
	    
	}

	@Override
	public void artikelBestandAktualisieren(int id, int menge) {
		
		Artikel artikel = artikelRepository.findArtikelById(new ArtikelId(id));
		
		if (artikel == null)
		  	return;
		
		artikel.setBestand(menge); 
		artikelRepository.save(artikel);		
    		
				
	}
	
	
}
