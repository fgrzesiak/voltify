package com.example.shop.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;

import com.example.shop.application.domain.Artikel;
import com.example.shop.application.domain.ArtikelId;

public class ArtikelEntity {
	
	@Id
	int id;
	int bestand;
	
	public ArtikelEntity() {	
	}
	
	public ArtikelEntity(int id, int bestand) {
		super();
		this.id = id;
		this.bestand = bestand;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBestand() {
		return bestand;
	}
	public void setBestand(int bestand) {
		this.bestand = bestand;
	}

	public ArtikelEntity (Artikel artikel) {
		this.id = artikel.getId().getId();
		this.bestand = artikel.getBestand();
			
		}
	
	public Artikel toDomain() {
		return new Artikel (new ArtikelId (id), bestand);
		
	}
	
	

}
