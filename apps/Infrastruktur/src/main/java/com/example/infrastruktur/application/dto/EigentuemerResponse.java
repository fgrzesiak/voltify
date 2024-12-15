package com.example.infrastruktur.application.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO für REST-Kommunikation (Request) über Grundstückseigentümer
 */
public class EigentuemerResponse {

    private Integer eigentuemerId;
    private String name;
    private String firmenadresse;
    private List<AnsprechpartnerDto> ansprechpartner;

    public EigentuemerResponse() {
        this.ansprechpartner = new ArrayList<>();
    }

    public EigentuemerResponse(Integer eigentuemerId, String name, String firmenadresse,
            List<AnsprechpartnerDto> ansprechpartner) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.firmenadresse = firmenadresse;
        this.ansprechpartner = ansprechpartner;
    }

    public Integer getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(Integer eigentuemerId) {
        this.eigentuemerId = eigentuemerId;
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
