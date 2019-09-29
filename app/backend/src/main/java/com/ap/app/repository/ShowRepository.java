package com.ap.app.repository;



import com.ap.app.entity.Show;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShowRepository extends JpaRepository<Show, Long>{
    Show findById(long id);
}