package com.example.lager.adapter.secondary.persistence;

import java.util.Optional;

import com.example.lager.application.domain.Artikel;
import com.example.lager.application.domain.ArtikelId;
import com.example.lager.application.port.secondary.ArtikelRepository;



public class ArtikelRepositoryImplDb implements ArtikelRepository {
		
	private final JdbcArtikelEntityRepository jdbcArtikelEntityRepository;
		
	public ArtikelRepositoryImplDb(JdbcArtikelEntityRepository jdbcArtikelEntityRepository) {
		this.jdbcArtikelEntityRepository = jdbcArtikelEntityRepository;
	}


		@Override
		public Artikel findArtikelById(ArtikelId artikelId) {
			  Optional<ArtikelEntity> artikelEntity = jdbcArtikelEntityRepository.findById(artikelId.getId());
		        if (artikelEntity.isPresent()) {
		            return artikelEntity.get().toDomain();
		        } else {
		            return null;
		        }
		}

		@Override
		public void save(Artikel artikel) {
			
			ArtikelEntity artikelEntity = new ArtikelEntity(artikel);
			jdbcArtikelEntityRepository.save(artikelEntity);
			
			return;
		}
			
}