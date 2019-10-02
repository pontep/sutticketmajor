package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.Carrer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CarrerRepository extends JpaRepository<Carrer, Long> {
	Carrer findById(long id);
}