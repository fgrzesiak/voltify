package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import com.example.infrastruktur.application.domain.Grundstueckseigentuemer;
import com.example.infrastruktur.application.domain.GrundstueckseigentuemerId;


public class GrundstueckseigentuemerEntity {

    @Id
    private String eigentuemerId;

    private String name;
    private String firmenadresse;

    // Bei Spring Data JDBC kann man ggf. eine separate Tabelle für Ansprechpartner abbilden.
    // Hier vereinfachen wir, indem wir sie NICHT normalisiert in eine separate Tabelle schieben
    // (Alternativ: One-to-Many Mapping in JDBC / JPA)

    // KEIN direkter Umgang mit Liste von Ansprechpartner im Entity, falls du es nicht mit Join-Tabelle abbilden willst.
    // Evtl. brauchst du eine separate Tabelle + Mapping.

    public GrundstueckseigentuemerEntity() {
    }

    public GrundstueckseigentuemerEntity(String eigentuemerId, String name, String firmenadresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.firmenadresse = firmenadresse;
    }

    /**
     * Convenience-Konstruktor zum Konvertieren aus Domain-Entität
     */
    public GrundstueckseigentuemerEntity(Grundstueckseigentuemer domain) {
        this.eigentuemerId = domain.getEigentuemerId().getId();
        this.name = domain.getName();
        this.firmenadresse = domain.getFirmenadresse();
        // Ansprechpartner-Liste müsste ggf. auch noch persistiert werden (eigenes Mapping).
    }

    /**
     * Konvertierung ins Domain-Objekt
     */
    public Grundstueckseigentuemer toDomain() {
        Grundstueckseigentuemer domainObj = new Grundstueckseigentuemer(
                new GrundstueckseigentuemerId(this.eigentuemerId),
                this.name,
                this.firmenadresse
        );
        // Falls Ansprechpartner existieren (hier nicht abgebildet), müssten wir domainObj.addAnsprechpartner(...) aufrufen.
        return domainObj;
    }

    // Getter / Setter
    public String getEigentuemerId() {
        return eigentuemerId;
    }
    public void setEigentuemerId(String eigentuemerId) {
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
}
