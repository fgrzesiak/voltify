package com.example.infrastruktur.application.port.secondary;

import com.example.infrastruktur.application.domain.Ladepunkt;
import com.example.infrastruktur.application.domain.LadepunktId;
import java.util.List;

public interface LadepunktRepository {
    Ladepunkt findById(LadepunktId id);
    void save(Ladepunkt ladepunkt);
    void delete(LadepunktId id);
    List<Ladepunkt> findAll();
}
