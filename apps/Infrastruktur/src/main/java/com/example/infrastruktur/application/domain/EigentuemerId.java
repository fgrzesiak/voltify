package com.example.infrastruktur.application.domain;

import java.util.Objects;

/**
 * Value Object für die eindeutige ID eines Eigentuemers
 */
public class EigentuemerId {

    private Integer id;

    public EigentuemerId() {
        this.id = null;
    }

    public EigentuemerId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EigentuemerId))
            return false;
        EigentuemerId EigentuemerId = (EigentuemerId) o;
        return Objects.equals(id, EigentuemerId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
