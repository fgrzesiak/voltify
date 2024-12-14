package com.example.infrastruktur.application.domain;

import java.util.Objects;
import java.util.UUID;

/**
 * Value Object für die eindeutige ID eines Ladepunkts
 */
public class LadepunktId {

    private final String id;

    public LadepunktId() {
        this.id = UUID.randomUUID().toString();
    }

    public LadepunktId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadepunktId)) return false;
        LadepunktId ladepunktId = (LadepunktId) o;
        return Objects.equals(id, ladepunktId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
