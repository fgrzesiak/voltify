package com.example.infrastruktur.application.domain;

/**
 * Entität (Aggregate Root), die einen Ladepunkt repräsentiert
 */
public class Ladepunkt {

    private LadepunktId ladepunktId;
    private String standort;           // z. B. "Musterstraße 1, 12345 Stadt"
    private double ladeleistungKW;     // z. B. 22.0
    private String anschlussart;       // z. B. "Typ 2", "CCS"
    private String verfuegbarkeit;     // z. B. "verfügbar", "in Wartung"
    private double gesamtleistungKWH;  // Summe aller geladenen kWh

    public Ladepunkt(LadepunktId ladepunktId,
                     String standort,
                     double ladeleistungKW,
                     String anschlussart,
                     String verfuegbarkeit,
                     double gesamtleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.standort = standort;
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    // Fachlogik, z. B. Wartung starten
    public void setzeInWartung() {
        this.verfuegbarkeit = "in Wartung";
    }

    // Getter/Setter
    public LadepunktId getLadepunktId() {
        return ladepunktId;
    }

    public String getStandort() {
        return standort;
    }

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public String getAnschlussart() {
        return anschlussart;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public double getGesamtleistungKWH() {
        return gesamtleistungKWH;
    }

    public void setGesamtleistungKWH(double gesamtleistungKWH) {
        this.gesamtleistungKWH = gesamtleistungKWH;
    }
}
