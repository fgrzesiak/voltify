package com.example.infrastruktur.application.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Entität für Grundstückseigentümer
 */
public class Grundstueckseigentuemer {

    private GrundstueckseigentuemerId eigentuemerId;
    private String name;
    private List<Ansprechpartner> ansprechpartner;
    private Adresse adresse;

    public Grundstueckseigentuemer(GrundstueckseigentuemerId eigentuemerId,
            String name,
            Adresse adresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.adresse = adresse;
        this.ansprechpartner = new ArrayList<>();
    }

    public void addAnsprechpartner(Ansprechpartner ap) {
        ansprechpartner.add(ap);
    }

    // Getter/Setter
    public GrundstueckseigentuemerId getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(GrundstueckseigentuemerId id) {
        this.eigentuemerId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Ansprechpartner> getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(List<Ansprechpartner> ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }
}
