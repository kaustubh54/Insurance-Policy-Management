package com.insurance.management.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Approved;

@Repository
public interface ApprovedRepository extends JpaRepositoryImplementation<Approved, String> {

}
