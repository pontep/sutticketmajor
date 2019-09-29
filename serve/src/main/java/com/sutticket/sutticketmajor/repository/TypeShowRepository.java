package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.TypeShow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TypeShowRepository extends JpaRepository<TypeShow, Long> {
	TypeShow findById(long id);
}
