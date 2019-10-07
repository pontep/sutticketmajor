package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.ShowTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {
    ShowTime findById(long id);
}