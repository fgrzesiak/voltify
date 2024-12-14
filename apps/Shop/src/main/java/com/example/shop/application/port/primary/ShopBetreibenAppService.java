package com.example.shop.application.port.primary;

public interface ShopBetreibenAppService {

	 public String bestandBewertungErmitteln(int id);
	 public void artikelBestandAktualisieren(int id, int menge);
}
