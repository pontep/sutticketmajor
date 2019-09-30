package com.sutticket.sutticketmajor.repository;

import com.sutticket.sutticketmajor.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee , Long>{
    Employee findById(long id);
}