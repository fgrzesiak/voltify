package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;    

import com.example.infrastruktur.application.domain.Ladepunkt;
import com.example.infrastruktur.application.domain.LadepunktId;

public class LadepunktEntity {

    @Id
    private String ladepunktId;

    private String standort;
    private double ladeleistungKW;
    private String anschlussart;
    private String verfuegbarkeit;
    private double gesamtleistungKWH;

    public LadepunktEntity() {
        // Leerer Konstruktor für Reflection (Spring Data)
    }

    public LadepunktEntity(String ladepunktId, String standort, double ladeleistungKW, 
                           String anschlussart, String verfuegbarkeit, double gesamtleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.standort = standort;
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    /**
     * Convenience-Konstruktor, um direkt aus der Domain-Entität eine Entity zu erstellen.
     */
    public LadepunktEntity(Ladepunkt domain) {
        this.ladepunktId = domain.getLadepunktId().getId();
        this.standort = domain.getStandort();
        this.ladeleistungKW = domain.getLadeleistungKW();
        this.anschlussart = domain.getAnschlussart();
        this.verfuegbarkeit = domain.getVerfuegbarkeit();
        this.gesamtleistungKWH = domain.getGesamtleistungKWH();
    }

    /**
     * Wandelt diese Persistence-Entity in die Domain-Entität `Ladepunkt` um.
     */
    public Ladepunkt toDomain() {
        return new Ladepunkt(
            new LadepunktId(this.ladepunktId),
            this.standort,
            this.ladeleistungKW,
            this.anschlussart,
            this.verfuegbarkeit,
            this.gesamtleistungKWH
        );
    }

    // Getter/Setter
    public String getLadepunktId() {
        return ladepunktId;
    }
    public void setLadepunktId(String ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public String getStandort() {
        return standort;
    }
    public void setStandort(String standort) {
        this.standort = standort;
    }

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }
    public void setLadeleistungKW(double ladeleistungKW) {
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

    public double getGesamtleistungKWH() {
        return gesamtleistungKWH;
    }
    public void setGesamtleistungKWH(double gesamtleistungKWH) {
        this.gesamtleistungKWH = gesamtleistungKWH;
    }
}
