package com.france.france.repository;

import com.france.france.entity.Carrer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface Carrerrepository extends JpaRepository<Carrer, Long> {
	Carrer findById(long id);
}