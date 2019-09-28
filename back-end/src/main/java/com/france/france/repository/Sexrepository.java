package com.france.france.repository;

import com.france.france.entity.Sex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface Sexrepository extends JpaRepository<Sex, Long> {
	Sex findById(long id);
}