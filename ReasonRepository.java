package com.ap.app.repository;

import com.ap.app.entity.Reason;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReasonRepository extends JpaRepository<Reason, Long>{
    
}