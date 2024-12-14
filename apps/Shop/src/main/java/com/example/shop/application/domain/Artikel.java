package com.example.shop.application.domain;

public class Artikel {
	private ArtikelId id;
	private int bestand;
	
	
	public Artikel() {
	}
	
	public Artikel(int bestand) {
		this.bestand = bestand;
	}
	
	public Artikel(ArtikelId id, int bestand) {
		this.id = id;
		this.bestand = bestand;
	}
	
	public ArtikelId getId() {
		return id;
	}
	public void setId(ArtikelId id) {
		this.id = id;
	}
	public int getBestand() {
		return bestand;
	}
	
	public void setBestand(int bestand) {
		this.bestand = bestand;
	}
	
	
	public String bewerteBestand () {
	
	 if (bestand > 100)
	        return "Status: grün";
	    else if (bestand > 50)
	        return "Status: gelb";
	    else
	        return "Status rot";
	}

}
