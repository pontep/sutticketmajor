package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.ShowRating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ShowRatingRepository extends JpaRepository<ShowRating , Long> {
	ShowRating findById(long id);
}
