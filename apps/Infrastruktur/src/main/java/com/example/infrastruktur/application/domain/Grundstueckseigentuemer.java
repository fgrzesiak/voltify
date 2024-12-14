package com.example.infrastruktur.application.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Entität für Grundstückseigentümer
 */
public class Grundstueckseigentuemer {

    private GrundstueckseigentuemerId eigentuemerId;
    private String name;
    private String firmenadresse;
    private List<Ansprechpartner> ansprechpartnerListe;

    public Grundstueckseigentuemer(GrundstueckseigentuemerId eigentuemerId,
                                   String name,
                                   String firmenadresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.firmenadresse = firmenadresse;
        this.ansprechpartnerListe = new ArrayList<>();
    }

    public void addAnsprechpartner(Ansprechpartner ap) {
        ansprechpartnerListe.add(ap);
    }

    // Getter/Setter
    public GrundstueckseigentuemerId getEigentuemerId() {
        return eigentuemerId;
    }

    public String getName() {
        return name;
    }

    public String getFirmenadresse() {
        return firmenadresse;
    }

    public List<Ansprechpartner> getAnsprechpartnerListe() {
        return ansprechpartnerListe;
    }
}
