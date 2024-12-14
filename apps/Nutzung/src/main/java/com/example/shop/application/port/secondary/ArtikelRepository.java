package com.example.shop.application.port.secondary;

import com.example.shop.application.domain.Artikel;
import com.example.shop.application.domain.ArtikelId;

public interface ArtikelRepository  {
	
	public Artikel findArtikelById(ArtikelId artikelId);
	public void save(Artikel artikel);
	
}