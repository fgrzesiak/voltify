package com.example.infrastruktur.adapter.primary.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.infrastruktur.application.port.primary.LadeinfrastrukturVerwaltungsAppService;
import com.example.infrastruktur.domain.model.EigentuemerDto;

import java.util.List;

@RestController
@RequestMapping("/eigentuemer")
public class GrundstueckseigentuemerController {

    private final LadeinfrastrukturVerwaltungsAppService ladeinfraService;

    public GrundstueckseigentuemerController(LadeinfrastrukturVerwaltungsAppService ladeinfraService) {
        this.ladeinfraService = ladeinfraService;
    }

    /**
     * GET /eigentuemer
     * 
     * Liefert alle Grundstückseigentümer als Liste.
     */
    @GetMapping
    public ResponseEntity<List<EigentuemerDto>> alleEigentuemerAnzeigen() {
        List<EigentuemerDto> eigentuemer = ladeinfraService.alleEigentuemerFinden();
        return new ResponseEntity<>(eigentuemer, HttpStatus.OK);
    }

    /**
     * GET /eigentuemer/{id}
     * 
     * Liefert Daten zu einem spezifischen Grundstückseigentümer.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EigentuemerDto> eigentuemerAnzeigen(@PathVariable("id") int eigentuemerId) {
        EigentuemerDto eigentuemer = ladeinfraService.eigentuemerFinden(eigentuemerId);
        if (eigentuemer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eigentuemer, HttpStatus.OK);
    }

    /**
     * POST /eigentuemer
     * 
     * Legt einen neuen Grundstückseigentümer an.
     */
    @PostMapping
    public ResponseEntity<String> eigentuemerAnlegen(@RequestBody EigentuemerDto eigentuemerDto) {
        int neuId = ladeinfraService.eigentuemerAnlegen(eigentuemerDto);
        if (neuId > 0) {
            return new ResponseEntity<>("Neuer Grundstückseigentümer mit ID=" + neuId + " angelegt.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Fehler beim Anlegen des Eigentümers", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PUT /eigentuemer/{id}
     * 
     * Aktualisiert die Daten eines Grundstückseigentümers.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> eigentuemerAktualisieren(@PathVariable("id") int eigentuemerId,
                                                          @RequestBody EigentuemerDto eigentuemerDto) {
        boolean aktualisiert = ladeinfraService.eigentuemerAktualisieren(eigentuemerId, eigentuemerDto);
        if (!aktualisiert) {
            return new ResponseEntity<>("Eigentümer nicht gefunden oder Update fehlgeschlagen", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Eigentümer aktualisiert", HttpStatus.OK);
    }

    /**
     * DELETE /eigentuemer/{id}
     * 
     * Löscht einen bestehenden Eigentümer.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eigentuemerLoeschen(@PathVariable("id") int eigentuemerId) {
        boolean geloescht = ladeinfraService.eigentuemerLoeschen(eigentuemerId);
        if (!geloescht) {
            return new ResponseEntity<>("Eigentümer nicht gefunden oder Löschen fehlgeschlagen", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Eigentümer gelöscht", HttpStatus.OK);
    }
}
