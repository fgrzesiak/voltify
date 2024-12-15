package com.example.infrastruktur.application.domain;

import java.util.Objects;

/**
 * Value Object für die Eigentümer-ID
 */
public class GrundstueckseigentuemerId {

    private Integer id;

    public GrundstueckseigentuemerId() {
        this.id = null;
    }

    public GrundstueckseigentuemerId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof GrundstueckseigentuemerId))
            return false;
        GrundstueckseigentuemerId other = (GrundstueckseigentuemerId) o;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
