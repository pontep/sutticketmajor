package com.okta.spring.repository;

import com.okta.spring.entity.Receipt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt , Long>{
    
}

