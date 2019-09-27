package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{
    
}