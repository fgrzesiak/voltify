package com.example.infrastruktur.application.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO für REST-Kommunikation (Request) über Grundstückseigentümer
 */
public class EigentuemerRequest {

    private String name;
    private String firmenadresse;
    private List<AnsprechpartnerDto> ansprechpartner;

    public EigentuemerRequest() {
        this.ansprechpartner = new ArrayList<>();
    }

    public EigentuemerRequest(String name, String firmenadresse, List<AnsprechpartnerDto> ansprechpartner) {
        this.name = name;
        this.firmenadresse = firmenadresse;
        this.ansprechpartner = ansprechpartner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirmenadresse() {
        return firmenadresse;
    }

    public void setFirmenadresse(String firmenadresse) {
        this.firmenadresse = firmenadresse;
    }

    public List<AnsprechpartnerDto> getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(List<AnsprechpartnerDto> ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }
}
