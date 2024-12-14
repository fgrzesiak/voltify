package com.example.infrastruktur.application.port.primary;

import com.example.infrastruktur.application.domain.LadepunktId;
import com.example.infrastruktur.application.domain.Ladepunkt;
import com.example.infrastruktur.application.domain.GrundstueckseigentuemerId;
import com.example.infrastruktur.application.domain.Grundstueckseigentuemer;

import java.util.List;

public interface LadeinfrastrukturVerwaltungsAppService {

    // Ladepunkt-Funktionen
    LadepunktId ladepunktAnlegen(Ladepunkt ladepunkt);
    Ladepunkt ladepunktFinden(LadepunktId ladepunktId);
    boolean ladepunktAktualisieren(LadepunktId ladepunktId, Ladepunkt neueDaten);
    boolean ladepunktLoeschen(LadepunktId ladepunktId);
    List<Ladepunkt> alleLadepunkteAnzeigen();

    // Eigentümer-Funktionen
    GrundstueckseigentuemerId eigentuemerAnlegen(Grundstueckseigentuemer eigentuemer);
    Grundstueckseigentuemer eigentuemerFinden(GrundstueckseigentuemerId eigentuemerId);
    boolean eigentuemerAktualisieren(GrundstueckseigentuemerId eigentuemerId, Grundstueckseigentuemer neueDaten);
    boolean eigentuemerLoeschen(GrundstueckseigentuemerId eigentuemerId);
    List<Grundstueckseigentuemer> alleEigentuemerAnzeigen();
}
