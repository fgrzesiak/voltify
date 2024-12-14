package com.example.infrastruktur.application.domain;

public class Artikel {
	private ArtikelId id;
	private int gewicht;
	private int bestand;
	
	

	public Artikel() {
	}
	public Artikel(ArtikelId id, int gewicht, int bestand) {
		this();
		this.id = id;
		this.gewicht = gewicht;
		this.bestand = bestand;
	}
	
	public ArtikelId getId() {
		return id;
	}
	
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	
	public int getGewicht() {
		return this.gewicht;
	}
	
	public int getBestand() {
		return bestand;
	}
	
	public void einlagern (int menge) {
		bestand += menge;		
	}
	
	public void auslagern (int menge) {
		bestand -= menge;
		
	}

}
