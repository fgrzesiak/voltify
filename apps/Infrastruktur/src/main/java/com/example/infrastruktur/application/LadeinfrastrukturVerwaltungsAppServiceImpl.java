package com.example.infrastruktur.application;

import com.example.infrastruktur.application.domain.*;
import com.example.infrastruktur.application.port.secondary.LadepunktRepository;
import com.example.infrastruktur.application.port.secondary.GrundstueckseigentuemerRepository;
import com.example.infrastruktur.application.port.primary.LadeinfrastrukturVerwaltungsAppService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LadeinfrastrukturVerwaltungsAppServiceImpl implements LadeinfrastrukturVerwaltungsAppService {

    private final LadepunktRepository ladepunktRepository;
    private final GrundstueckseigentuemerRepository eigentuemerRepository;
    private final LadepunktDomainService ladepunktDomainService;

    // Konstruktor (jetzt mit ladepunktDomainService)
    public LadeinfrastrukturVerwaltungsAppServiceImpl(
            LadepunktRepository ladepunktRepository,
            GrundstueckseigentuemerRepository eigentuemerRepository,
            LadepunktDomainService ladepunktDomainService) {
        this.ladepunktRepository = ladepunktRepository;
        this.eigentuemerRepository = eigentuemerRepository;
        this.ladepunktDomainService = ladepunktDomainService;
    }

    // ------------------------------------------------------
    // Ladepunkt-Funktionen
    // ------------------------------------------------------

    @Override
    public LadepunktId ladepunktAnlegen(Ladepunkt ladepunkt) {
        LadepunktId newId = new LadepunktId();
        Ladepunkt neuerPunkt = new Ladepunkt(
                newId,
                ladepunkt.getStandort(),
                ladepunkt.getLadeleistungKW(),
                ladepunkt.getAnschlussart(),
                ladepunkt.getVerfuegbarkeit(),
                ladepunkt.getGesamtleistungKWH()
        );
        ladepunktRepository.save(neuerPunkt);
        return newId;
    }

    @Override
    public Ladepunkt ladepunktFinden(LadepunktId ladepunktId) {
        return ladepunktRepository.findById(ladepunktId);
    }

    @Override
    public boolean ladepunktAktualisieren(LadepunktId ladepunktId, Ladepunkt neueDaten) {
        Ladepunkt lpAlt = ladepunktRepository.findById(ladepunktId);
        if (lpAlt == null) {
            return false;
        }
        lpAlt.setGesamtleistungKWH(neueDaten.getGesamtleistungKWH());
        // ggf. weitere Felder
        ladepunktRepository.save(lpAlt);
        return true;
    }

    @Override
    public boolean ladepunktLoeschen(LadepunktId ladepunktId) {
        Ladepunkt lp = ladepunktRepository.findById(ladepunktId);
        if (lp == null) {
            return false;
        }
        ladepunktRepository.delete(ladepunktId);
        return true;
    }

    @Override
    public List<Ladepunkt> alleLadepunkteAnzeigen() {
        return ladepunktRepository.findAll();
    }

    /**
     * NEU: Beispielmethode, die einen Ladevorgang verbucht.
     * Ruft den Domain Service auf, der dann Events etc. publiziert.
     */
    public boolean ladevorgangVerbuchen(LadepunktId ladepunktId, double geladeneKWh) {
        Ladepunkt lp = ladepunktRepository.findById(ladepunktId);
        if (lp == null) {
            return false;
        }
        // Fachlogik über DomainService aufrufen
        ladepunktDomainService.verarbeiteLadevorgang(lp, geladeneKWh);
        // geänderten Ladepunkt speichern
        ladepunktRepository.save(lp);
        return true;
    }

    // ------------------------------------------------------
    // Eigentümer-Funktionen
    // ------------------------------------------------------

    @Override
    public GrundstueckseigentuemerId eigentuemerAnlegen(Grundstueckseigentuemer eigentuemer) {
        GrundstueckseigentuemerId newId = new GrundstueckseigentuemerId();
        Grundstueckseigentuemer neu = new Grundstueckseigentuemer(
                newId,
                eigentuemer.getName(),
                eigentuemer.getFirmenadresse()
        );
        eigentuemerRepository.save(neu);
        return newId;
    }

    @Override
    public Grundstueckseigentuemer eigentuemerFinden(GrundstueckseigentuemerId eigentuemerId) {
        return eigentuemerRepository.findById(eigentuemerId);
    }

    @Override
    public boolean eigentuemerAktualisieren(GrundstueckseigentuemerId eigentuemerId, Grundstueckseigentuemer neueDaten) {
        Grundstueckseigentuemer alt = eigentuemerRepository.findById(eigentuemerId);
        if (alt == null) {
            return false;
        }
        eigentuemerRepository.save(alt);
        return true;
    }

    @Override
    public boolean eigentuemerLoeschen(GrundstueckseigentuemerId eigentuemerId) {
        Grundstueckseigentuemer eig = eigentuemerRepository.findById(eigentuemerId);
        if (eig == null) {
            return false;
        }
        eigentuemerRepository.delete(eigentuemerId);
        return true;
    }

    @Override
    public List<Grundstueckseigentuemer> alleEigentuemerAnzeigen() {
        return eigentuemerRepository.findAll();
    }
}
