package com.insurance.management.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Queries;
import com.insurance.management.repository.QueriesRepository;


@Service
public class QueriesService {

	@Autowired
	QueriesRepository queriesRepository;
	
	@Transactional
	public List<Queries> fetchQueries() {
		List<Queries> queriesList=queriesRepository.findAll();
		return queriesList;
		
	}
	@Transactional
	public Queries saveQuery(Queries queries) {
		
		return queriesRepository.save(queries);
		
	}
	@Transactional
	public void updateQuery(Queries queries) {
		queriesRepository.save(queries);	
	
	}
	
	@Transactional
	public void deleteQuery(String userName) {
		queriesRepository.deleteById(userName);
	
	}
	@Transactional 
	  public Queries getQuery(String userName) { 
	  Optional<Queries> optional= queriesRepository.findById(userName);
	  Queries queries=optional.get();
	  return queries;
	  }
	
}
