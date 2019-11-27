package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.ShowType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ShowTypeRepository extends JpaRepository<ShowType, Long> {
	ShowType findById(long id);
}
