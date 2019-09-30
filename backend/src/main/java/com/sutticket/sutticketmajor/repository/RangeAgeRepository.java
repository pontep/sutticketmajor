package com.sutticket.sutticketmajor.repository;


import com.sutticket.sutticketmajor.entity.RangeAge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface RangeAgeRepository extends JpaRepository<RangeAge, Long> {
	RangeAge findById(long id);
	
}