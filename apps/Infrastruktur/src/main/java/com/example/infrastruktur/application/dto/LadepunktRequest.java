package com.example.infrastruktur.application.dto;

public class LadepunktRequest {
    private String standort;
    private Double ladeleistungKW;
    private String anschlussart;
    private String verfuegbarkeit;
    private Double gesamtleistungKWH;

    public LadepunktRequest() {}

    public LadepunktRequest(String standort, Double ladeleistungKW, String anschlussart, String verfuegbarkeit, Double gesamtleistungKWH) {
        this.standort = standort;
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    public String getStandort() {
        return standort;
    }
    public void setStandort(String standort) {
        this.standort = standort;
    }

    public Double getLadeleistungKW() {
        return ladeleistungKW;
    }
    public void setLadeleistungKW(Double ladeleistungKW) {
        this.ladeleistungKW = ladeleistungKW;
    }

    public String getAnschlussart() {
        return anschlussart;
    }
    public void setAnschlussart(String anschlussart) {
        this.anschlussart = anschlussart;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }
    public void setVerfuegbarkeit(String verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }

    public Double getGesamtleistungKWH() {
        return gesamtleistungKWH;
    }
    public void setGesamtleistungKWH(Double gesamtleistungKWH) {
        this.gesamtleistungKWH = gesamtleistungKWH;
    }
}
