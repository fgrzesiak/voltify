package com.example.infrastruktur.application.domain;

import java.util.Objects;

/**
 * Repräsentiert einen Ansprechpartner (Value Object) mit Kontaktdaten.
 */
public class Ansprechpartner {

    private String name;
    private String telefon;
    private String email;
    private Adresse adresse;

    // Leerer Konstruktor, falls für Serialisierung (z.B. JSON) benötigt
    public Ansprechpartner() {
    }

    public Ansprechpartner(String name, Adresse adresse, String telefon, String email) {
        this.name = name;
        this.adresse = adresse;
        this.telefon = telefon;
        this.email = email;
    }

    // Getter / Setter
    public String getName() {
        return name;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // equals / hashCode (typisch für Value Objects)
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ansprechpartner))
            return false;
        Ansprechpartner that = (Ansprechpartner) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(telefon, that.telefon) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, adresse, telefon, email);
    }
}
