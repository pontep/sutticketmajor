package com.sutticket.sutticketmajor.repository;


import com.sutticket.sutticketmajor.entity.Career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CareerRepository extends JpaRepository<Career, Long> {
	Career findById(long id);
}