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
    private List<Ansprechpartner> ansprechpartner;

    public Grundstueckseigentuemer(GrundstueckseigentuemerId eigentuemerId,
            String name,
            String firmenadresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.firmenadresse = firmenadresse;
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

    public String getFirmenadresse() {
        return firmenadresse;
    }

    public void setFirmenadresse(String firmenadresse) {
        this.firmenadresse = firmenadresse;
    }

    public List<Ansprechpartner> getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(List<Ansprechpartner> ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }
}
