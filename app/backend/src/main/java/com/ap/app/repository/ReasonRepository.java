package com.ap.app.repository;

import com.ap.app.entity.Reason;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReasonRepository extends JpaRepository<Reason, Long>{
    Reason findById(long id);
}
