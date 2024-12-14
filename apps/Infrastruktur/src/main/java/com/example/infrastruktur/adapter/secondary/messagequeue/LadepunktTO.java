package com.example.infrastruktur.adapter.secondary.messagequeue;

import java.time.LocalDateTime;

/**
 * Transfer Object für ein Ladepunkt-Event.
 * Hier z.B. ein fiktives "LadepunktAktualisiertEvent".
 */
public class LadepunktTO {

    private String ladepunktId;
    private double neueGesamtleistungKWH;
    private LocalDateTime timestamp;

    public LadepunktTO(String ladepunktId, double neueGesamtleistungKWH) {
		this.ladepunktId = ladepunktId;
		this.neueGesamtleistungKWH = neueGesamtleistungKWH;
		this.timestamp = LocalDateTime.now();
    }

    public LadepunktTO(String ladepunktId, double neueGesamtleistungKWH, LocalDateTime timestamp) {
        this.ladepunktId = ladepunktId;
        this.neueGesamtleistungKWH = neueGesamtleistungKWH;
        this.timestamp = timestamp;
    }

    public String getLadepunktId() {
        return ladepunktId;
    }

    public double getNeueGesamtleistungKWH() {
        return neueGesamtleistungKWH;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setLadepunktId(String ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public void setNeueGesamtleistungKWH(double neueGesamtleistungKWH) {
        this.neueGesamtleistungKWH = neueGesamtleistungKWH;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
