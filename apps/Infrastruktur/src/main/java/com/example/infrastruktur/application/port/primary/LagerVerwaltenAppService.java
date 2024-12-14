package com.example.infrastruktur.application.port.primary;


public interface LagerVerwaltenAppService {

	 public int artkelEinlagern(int id, int menge);
	 public int bestandErmitteln(int id);
}
