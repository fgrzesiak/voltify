package com.example.infrastruktur.application.dto;

/**
 * Value Object für Adress-Daten
 */
public class AdresseDto {

    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;

    public AdresseDto() {
    }

    // Konstruktor mit allen nötigen Feldern
    public AdresseDto(String strasse, String hausnummer, String plz, String ort) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }

    // Getter
    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }

    // Setter
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

}
