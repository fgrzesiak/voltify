package com.example.infrastruktur.adapter.primary.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.infrastruktur.application.port.primary.LadeinfrastrukturVerwaltungsAppService;
import com.example.infrastruktur.domain.model.LadepunktDto;

@RestController
@RequestMapping("/ladepunkte")
public class LadepunktController {

    private final LadeinfrastrukturVerwaltungsAppService ladeinfraService;

    public LadepunktController(LadeinfrastrukturVerwaltungsAppService ladeinfraService) {
        this.ladeinfraService = ladeinfraService;
    }

    /**
     * GET /ladepunkte/{id}
     * 
     * Liefert Informationen zu einem spezifischen Ladepunkt.
     */
    @GetMapping("/{id}")
    public ResponseEntity<LadepunktDto> ladepunktAnzeigen(@PathVariable("id") int ladepunktId) {
        LadepunktDto ladepunkt = ladeinfraService.ladepunktFinden(ladepunktId);
        if (ladepunkt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ladepunkt, HttpStatus.OK);
    }

    /**
     * POST /ladepunkte
     * 
     * Legt einen neuen Ladepunkt an.
     */
    @PostMapping
    public ResponseEntity<String> ladepunktAnlegen(@RequestBody LadepunktDto ladepunktDto) {
        int neuId = ladeinfraService.ladepunktAnlegen(ladepunktDto);
        if (neuId > 0) {
            return new ResponseEntity<>("Neuer Ladepunkt mit ID=" + neuId + " angelegt.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Fehler beim Anlegen des Ladepunkts", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PUT /ladepunkte/{id}
     * 
     * Aktualisiert die Daten eines bestehenden Ladepunkts.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> ladepunktAktualisieren(@PathVariable("id") int ladepunktId,
                                                        @RequestBody LadepunktDto ladepunktDto) {
        boolean aktualisiert = ladeinfraService.ladepunktAktualisieren(ladepunktId, ladepunktDto);
        if (!aktualisiert) {
            return new ResponseEntity<>("Ladepunkt nicht gefunden oder Update fehlgeschlagen", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Ladepunkt aktualisiert", HttpStatus.OK);
    }

    /**
     * DELETE /ladepunkte/{id}
     * 
     * Löscht einen bestehenden Ladepunkt.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> ladepunktLoeschen(@PathVariable("id") int ladepunktId) {
        boolean geloescht = ladeinfraService.ladepunktLoeschen(ladepunktId);
        if (!geloescht) {
            return new ResponseEntity<>("Ladepunkt nicht gefunden oder Löschen fehlgeschlagen", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Ladepunkt gelöscht", HttpStatus.OK);
    }
}
