package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import com.example.infrastruktur.application.domain.Adresse;
import com.example.infrastruktur.application.domain.EigentuemerId;
import com.example.infrastruktur.application.domain.Ladepunkt;
import com.example.infrastruktur.application.domain.LadepunktId;

public class LadepunktEntity {

    @Id
    private Integer ladepunktId;
    private Integer eigentuemerId;
    private Double ladeleistungKW;
    private String anschlussart;
    private String verfuegbarkeit;
    private Double gesamtleistungKWH;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private AdresseEntity adresse;

    public LadepunktEntity() {
        // Leerer Konstruktor für Reflection (Spring Data)
    }

    public LadepunktEntity(Integer ladepunktId, Integer eigentuemerId, Adresse adresse, Double ladeleistungKW,
            String anschlussart, String verfuegbarkeit, Double gesamtleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.eigentuemerId = eigentuemerId;
        this.adresse = new AdresseEntity(adresse);
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    /**
     * Convenience-Konstruktor, um direkt aus der Domain-Entität eine Entity zu
     * erstellen.
     */
    public LadepunktEntity(Ladepunkt domain) {
        this.ladepunktId = domain.getLadepunktId().getId();
        this.eigentuemerId = domain.getEigentuemerId().getId();
        this.adresse = new AdresseEntity(domain.getAdresse());
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
                new EigentuemerId(this.eigentuemerId),
                this.adresse.toDomain(),
                this.ladeleistungKW,
                this.anschlussart,
                this.verfuegbarkeit,
                this.gesamtleistungKWH);
    }

    // Getter/Setter
    public Integer getLadepunktId() {
        return ladepunktId;
    }

    public void setLadepunktId(Integer ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public Integer getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(Integer eigentuemerId) {
        this.eigentuemerId = eigentuemerId;
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
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
