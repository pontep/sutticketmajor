package com.cpe.black.repository;

import com.cpe.black.entity.ShowSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShowScheduleRepository extends JpaRepository<ShowSchedule, Long> {}