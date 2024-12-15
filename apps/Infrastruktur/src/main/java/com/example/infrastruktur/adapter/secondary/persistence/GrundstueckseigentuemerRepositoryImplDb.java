package com.example.infrastruktur.adapter.secondary.persistence;

import com.example.infrastruktur.application.domain.Grundstueckseigentuemer;
import com.example.infrastruktur.application.domain.GrundstueckseigentuemerId;
import com.example.infrastruktur.application.port.secondary.GrundstueckseigentuemerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GrundstueckseigentuemerRepositoryImplDb implements GrundstueckseigentuemerRepository {

    private final JdbcGrundstueckseigentuemerEntityRepository jdbcRepo;

    public GrundstueckseigentuemerRepositoryImplDb(JdbcGrundstueckseigentuemerEntityRepository jdbcRepo) {
        this.jdbcRepo = jdbcRepo;
    }

    @Override
    public Grundstueckseigentuemer findById(GrundstueckseigentuemerId id) {
        Optional<GrundstueckseigentuemerEntity> entity = jdbcRepo.findById(id.getId());
        return entity.map(GrundstueckseigentuemerEntity::toDomain).orElse(null);
    }

    @Override
    public void save(Grundstueckseigentuemer eigentuemer) {
        GrundstueckseigentuemerEntity entity = new GrundstueckseigentuemerEntity(eigentuemer);
        jdbcRepo.save(entity);
        eigentuemer.setEigentuemerId(new GrundstueckseigentuemerId(entity.getEigentuemerId())); // set auto-generated ID
    }

    @Override
    public void delete(GrundstueckseigentuemerId id) {
        jdbcRepo.deleteById(id.getId());
    }

    @Override
    public List<Grundstueckseigentuemer> findAll() {
        return ((List<GrundstueckseigentuemerEntity>) jdbcRepo.findAll())
                .stream()
                .map(GrundstueckseigentuemerEntity::toDomain)
                .collect(Collectors.toList());
    }
}
