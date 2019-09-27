package com.okta.spring.repository;

import com.okta.spring.entity.Receipt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReceiptRepository extends JpaRepository<Receipt , Long>{
    
}
