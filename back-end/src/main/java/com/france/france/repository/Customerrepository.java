package com.france.france.repository;

import com.france.france.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface Customerrepository extends JpaRepository<Customer, Long> {
}