package com.insurance.management.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Disapproved;

@Repository
public interface DisapprovedRepository extends JpaRepositoryImplementation<Disapproved, String> {

}
