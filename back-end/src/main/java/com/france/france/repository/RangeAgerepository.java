package com.france.france.repository;

import com.france.france.entity.RangeAge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface RangeAgerepository extends JpaRepository<RangeAge, Long> {
	RangeAge findById(long id);
}