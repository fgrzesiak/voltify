package com.example.infrastruktur.adapter.secondary.persistence;


import org.springframework.data.repository.CrudRepository;

public interface JdbcLadepunktEntityRepository 
	extends CrudRepository<LadepunktEntity, String> {

}
