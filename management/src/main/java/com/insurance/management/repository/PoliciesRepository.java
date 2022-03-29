package com.insurance.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Policies;

@Repository
public interface PoliciesRepository extends JpaRepository<Policies, Integer> {

}
