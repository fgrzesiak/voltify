package com.example.infrastruktur.application.port.secondary;

import com.example.infrastruktur.application.domain.Grundstueckseigentuemer;
import com.example.infrastruktur.application.domain.GrundstueckseigentuemerId;
import java.util.List;

public interface GrundstueckseigentuemerRepository {
    Grundstueckseigentuemer findById(GrundstueckseigentuemerId id);
    void save(Grundstueckseigentuemer eigentuemer);
    void delete(GrundstueckseigentuemerId id);
    List<Grundstueckseigentuemer> findAll();
}
