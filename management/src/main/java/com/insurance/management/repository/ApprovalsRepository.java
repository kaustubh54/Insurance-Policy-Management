package com.insurance.management.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Approvals;

@Repository
public interface ApprovalsRepository extends JpaRepositoryImplementation<Approvals, String> {

}
