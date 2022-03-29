package com.insurance.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Queries;

@Repository
public interface QueriesRepository extends JpaRepository<Queries, String> {

}
