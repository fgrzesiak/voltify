package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.domain.Grundstueckseigentuemer;
import com.example.infrastruktur.application.domain.GrundstueckseigentuemerId;
import com.example.infrastruktur.application.port.primary.LadeinfrastrukturVerwaltungsAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eigentuemer")
public class GrundstueckseigentuemerController {

    private final LadeinfrastrukturVerwaltungsAppService service;

    public GrundstueckseigentuemerController(LadeinfrastrukturVerwaltungsAppService service) {
        this.service = service;
    }

    /**
     * POST /eigentuemer
     * Legt einen neuen Eigentümer an
     */
    @PostMapping
    public ResponseEntity<String> eigentuemerAnlegen(@RequestBody Grundstueckseigentuemer eigentuemerDto) {
        GrundstueckseigentuemerId newId = service.eigentuemerAnlegen(eigentuemerDto);
        return new ResponseEntity<>("Neuer Eigentümer mit ID=" + newId.getId() + " angelegt.", HttpStatus.CREATED);
    }

    /**
     * GET /eigentuemer/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Grundstueckseigentuemer> eigentuemerFinden(@PathVariable("id") String id) {
        GrundstueckseigentuemerId eigentuemerId = new GrundstueckseigentuemerId(id);
        Grundstueckseigentuemer eigentuemer = service.eigentuemerFinden(eigentuemerId);
        if (eigentuemer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eigentuemer, HttpStatus.OK);
    }

    /**
     * PUT /eigentuemer/{id}
     * Aktualisiert Daten eines Eigentümers
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> eigentuemerAktualisieren(
            @PathVariable("id") String id,
            @RequestBody Grundstueckseigentuemer neueDaten) {
        GrundstueckseigentuemerId eigentuemerId = new GrundstueckseigentuemerId(id);
        boolean success = service.eigentuemerAktualisieren(eigentuemerId, neueDaten);
        if (!success) {
            return new ResponseEntity<>("Eigentümer nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Eigentümer aktualisiert", HttpStatus.OK);
    }

    /**
     * DELETE /eigentuemer/{id}
     * Löscht Eigentümer
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eigentuemerLoeschen(@PathVariable("id") String id) {
        GrundstueckseigentuemerId eigentuemerId = new GrundstueckseigentuemerId(id);
        boolean deleted = service.eigentuemerLoeschen(eigentuemerId);
        if (!deleted) {
            return new ResponseEntity<>("Eigentümer nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Eigentümer gelöscht", HttpStatus.OK);
    }

    /**
     * GET /eigentuemer
     * Liefert alle Eigentümer
     */
    @GetMapping
    public List<Grundstueckseigentuemer> alleEigentuemer() {
        return service.alleEigentuemerAnzeigen();
    }
}
