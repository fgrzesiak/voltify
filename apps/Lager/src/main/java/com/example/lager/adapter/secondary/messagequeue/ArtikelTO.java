package com.example.lager.adapter.secondary.messagequeue;


public class ArtikelTO {

	int id;
	int bestand;
	
	
	public ArtikelTO(int id, int bestand) {
		this.id = id;
		this.bestand = bestand;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public int getBestand() {
		return bestand;
	}
	public void setBestand(int bestand) {
		this.bestand = bestand;
	}

	
}
