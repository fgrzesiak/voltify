package com.example.infrastruktur.application.domain;

import java.util.Objects;

/**
 * Value Object für die eindeutige ID eines Ladepunkts
 */
public class LadepunktId {

    private Integer id;

    public LadepunktId() {
        this.id = null;
    }

    public LadepunktId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LadepunktId))
            return false;
        LadepunktId ladepunktId = (LadepunktId) o;
        return Objects.equals(id, ladepunktId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
