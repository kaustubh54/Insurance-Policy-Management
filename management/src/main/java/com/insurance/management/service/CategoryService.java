package com.insurance.management.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Category;
import com.insurance.management.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Transactional
	public List<Category> fetchCategory() {
		List<Category> list = categoryRepository.findAll();
		return list;

	}

	@Transactional
	public Category SaveCategory(Category category) {

		return categoryRepository.save(category);

	}
	
	@Transactional
	public String deleteCategory(String category) {
		categoryRepository.deleteById(category);
		return "deleted";
	}

	@Transactional
	public Category getCategory(String Category) {
		Optional<Category> optional = categoryRepository.findById(Category);
		Category insuranceCategory = optional.get();
		return insuranceCategory;

	}
}
