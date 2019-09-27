package com.okta.spring.repository;



import com.okta.spring.entity.ShowSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShowScheduleRepository extends JpaRepository<ShowSchedule, Long>{
    ShowSchedule findById(long id);
}