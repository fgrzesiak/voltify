package com.example.lager.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;

import com.example.lager.application.domain.Artikel;
import com.example.lager.application.domain.ArtikelId;

public class ArtikelEntity {
	
	@Id
	int id;
	int bestand;
	int gewicht;
	
	public ArtikelEntity() {
	}

	public ArtikelEntity(int id, int gewicht, int bestand) {
		super();
		this.id = id;
		this.bestand = bestand;
		this.gewicht = gewicht;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}


	public int getGewicht() {
		return gewicht;
	}
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
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
		this.gewicht = artikel.getGewicht();
		}
	
	public Artikel toDomain() {
		return new Artikel (new ArtikelId (id), gewicht, bestand);
		
	}
	
	

}
