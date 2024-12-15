package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.domain.Ladepunkt;
import com.example.infrastruktur.application.domain.LadepunktId;
import com.example.infrastruktur.application.port.primary.LadeinfrastrukturVerwaltungsAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ladepunkte")
public class LadepunktController {

    private final LadeinfrastrukturVerwaltungsAppService service;

    public LadepunktController(LadeinfrastrukturVerwaltungsAppService service) {
        this.service = service;
    }

    /**
     * POST /ladepunkte
     * Legt einen neuen Ladepunkt an.
     */
    @PostMapping
    public ResponseEntity<String> ladepunktAnlegen(@RequestBody Ladepunkt ladepunktDto) {
        LadepunktId newId = service.ladepunktAnlegen(ladepunktDto);
        return new ResponseEntity<>("Neuer Ladepunkt mit ID=" + newId.getId() + " angelegt.", HttpStatus.CREATED);
    }

    /**
     * GET /ladepunkte/{id}
     * Holt einen Ladepunkt anhand seiner ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ladepunkt> ladepunktFinden(@PathVariable("id") String id) {
        LadepunktId ladepunktId = new LadepunktId(id);
        Ladepunkt ladepunkt = service.ladepunktFinden(ladepunktId);
        if (ladepunkt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ladepunkt, HttpStatus.OK);
    }

    /**
     * PUT /ladepunkte/{id}
     * Aktualisiert einen bestehenden Ladepunkt.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> ladepunktAktualisieren(
            @PathVariable("id") String id,
            @RequestBody Ladepunkt neueDaten) {
        LadepunktId ladepunktId = new LadepunktId(id);
        boolean success = service.ladepunktAktualisieren(ladepunktId, neueDaten);
        if (!success) {
            return new ResponseEntity<>("Ladepunkt nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Ladepunkt aktualisiert", HttpStatus.OK);
    }

    /**
     * DELETE /ladepunkte/{id}
     * Löscht einen Ladepunkt.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> ladepunktLoeschen(@PathVariable("id") String id) {
        LadepunktId ladepunktId = new LadepunktId(id);
        boolean deleted = service.ladepunktLoeschen(ladepunktId);
        if (!deleted) {
            return new ResponseEntity<>("Ladepunkt nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Ladepunkt gelöscht", HttpStatus.OK);
    }

    /**
     * GET /ladepunkte
     * Liefert eine Liste aller Ladepunkte.
     */
    @GetMapping
    public List<Ladepunkt> alleLadepunkte() {
        return service.alleLadepunkteAnzeigen();
    }
}
