package com.okta.spring.repository;

import com.okta.spring.entity.Complacency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplacencyRepository extends JpaRepository<Complacency , Long>{
    
}