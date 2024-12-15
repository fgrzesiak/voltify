package com.example.infrastruktur.application.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO für REST-Kommunikation (Request) über Grundstückseigentümer
 */
public class EigentuemerRequest {

    private String name;
    private AdresseDto adresse;
    private List<AnsprechpartnerDto> ansprechpartner;

    public EigentuemerRequest() {
        this.ansprechpartner = new ArrayList<>();
    }

    public EigentuemerRequest(String name, AdresseDto adresse, List<AnsprechpartnerDto> ansprechpartner) {
        this.name = name;
        this.adresse = adresse;
        this.ansprechpartner = ansprechpartner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }

    public List<AnsprechpartnerDto> getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(List<AnsprechpartnerDto> ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }
}
