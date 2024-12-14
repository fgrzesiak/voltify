package com.example.infrastruktur.application.domain;

import java.util.Objects;
import java.util.UUID;

/**
 * Value Object für die Eigentümer-ID
 */
public class GrundstueckseigentuemerId {

    private final String id;

    public GrundstueckseigentuemerId() {
        this.id = UUID.randomUUID().toString();
    }

    public GrundstueckseigentuemerId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrundstueckseigentuemerId)) return false;
        GrundstueckseigentuemerId other = (GrundstueckseigentuemerId) o;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
