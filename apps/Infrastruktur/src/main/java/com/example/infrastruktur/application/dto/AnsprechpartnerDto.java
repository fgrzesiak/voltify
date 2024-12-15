package com.example.infrastruktur.application.dto;

public class AnsprechpartnerDto {
    private String name;
    private String adresse;
    private String telefon;
    private String email;

    public AnsprechpartnerDto() {
    }

    public AnsprechpartnerDto(String name, String adresse, String telefon, String email) {
        this.name = name;
        this.adresse = adresse;
        this.telefon = telefon;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
