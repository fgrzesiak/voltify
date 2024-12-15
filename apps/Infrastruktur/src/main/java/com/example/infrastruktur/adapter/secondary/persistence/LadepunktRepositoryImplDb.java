package com.example.infrastruktur.adapter.secondary.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.infrastruktur.application.domain.Ladepunkt;
import com.example.infrastruktur.application.domain.LadepunktId;
import com.example.infrastruktur.application.port.secondary.LadepunktRepository;

/**
 * Implementierung des LadepunktRepository für die DB.
 * Greift intern auf ein JdbcLadepunktEntityRepository (oder Spring Data Repo)
 * zu.
 */
public class LadepunktRepositoryImplDb implements LadepunktRepository {

    private final JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository;

    // Konstruktor-Injection
    public LadepunktRepositoryImplDb(JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository) {
        this.jdbcLadepunktEntityRepository = jdbcLadepunktEntityRepository;
    }

    @Override
    public Ladepunkt findById(LadepunktId ladepunktId) {
        Optional<LadepunktEntity> ladepunktEntity = jdbcLadepunktEntityRepository.findById(ladepunktId.getId());
        return ladepunktEntity.map(LadepunktEntity::toDomain).orElse(null);
    }

    @Override
    public void save(Ladepunkt ladepunkt) {
        LadepunktEntity ladepunktEntity = new LadepunktEntity(ladepunkt);
        jdbcLadepunktEntityRepository.save(ladepunktEntity);
        ladepunkt.setLadepunktId(new LadepunktId(ladepunktEntity.getLadepunktId())); // set auto-generated ID
    }

    @Override
    public void delete(LadepunktId ladepunktId) {
        jdbcLadepunktEntityRepository.deleteById(ladepunktId.getId());
    }

    @Override
    public List<Ladepunkt> findAll() {
        return ((List<LadepunktEntity>) jdbcLadepunktEntityRepository.findAll())
                .stream()
                .map(LadepunktEntity::toDomain)
                .collect(Collectors.toList());
    }
}
