package com.example.infrastruktur.application.port.secondary;

import com.example.infrastruktur.application.domain.Artikel;
import com.example.infrastruktur.application.domain.ArtikelId;

public interface ArtikelRepository  {
	
	public Artikel findArtikelById(ArtikelId artikelId);
	public void save(Artikel artikel);
	
}