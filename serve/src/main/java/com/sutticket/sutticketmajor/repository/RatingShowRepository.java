package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.RatingShow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface RatingShowRepository extends JpaRepository<RatingShow , Long> {
	RatingShow findById(long id);
}
