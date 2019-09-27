package com.cpe.black.repository;

import com.cpe.black.entity.ShowTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {
    ShowTime findById(long id);
}