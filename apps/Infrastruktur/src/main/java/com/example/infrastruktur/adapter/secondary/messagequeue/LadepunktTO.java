package com.example.infrastruktur.adapter.secondary.messagequeue;

import java.time.LocalDateTime;

/**
 * Transfer Object für ein Ladepunkt-Event.
 * Hier z.B. ein fiktives "LadepunktAktualisiertEvent".
 */
public class LadepunktTO {

    private Integer ladepunktId;
    private Double neueGesamtleistungKWH;
    private LocalDateTime timestamp;

    public LadepunktTO(Integer ladepunktId, Double neueGesamtleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.neueGesamtleistungKWH = neueGesamtleistungKWH;
        this.timestamp = LocalDateTime.now();
    }

    public LadepunktTO(Integer ladepunktId, Double neueGesamtleistungKWH, LocalDateTime timestamp) {
        this.ladepunktId = ladepunktId;
        this.neueGesamtleistungKWH = neueGesamtleistungKWH;
        this.timestamp = timestamp;
    }

    public Integer getLadepunktId() {
        return ladepunktId;
    }

    public Double getNeueGesamtleistungKWH() {
        return neueGesamtleistungKWH;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setLadepunktId(Integer ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public void setNeueGesamtleistungKWH(Double neueGesamtleistungKWH) {
        this.neueGesamtleistungKWH = neueGesamtleistungKWH;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
