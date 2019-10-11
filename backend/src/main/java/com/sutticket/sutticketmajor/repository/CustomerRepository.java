package com.sutticket.sutticketmajor.repository;


import com.sutticket.sutticketmajor.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(long id);
    //Customer findByUsername(String username);
    Customer findByUsername(String username);
    Customer findByUsernameAndPassword(String username, String password);
}