package com.example.lager.application.port.secondary;

import com.example.lager.application.domain.Artikel;
import com.example.lager.application.domain.ArtikelId;

public interface ArtikelRepository  {
	
	public Artikel findArtikelById(ArtikelId artikelId);
	public void save(Artikel artikel);
	
}