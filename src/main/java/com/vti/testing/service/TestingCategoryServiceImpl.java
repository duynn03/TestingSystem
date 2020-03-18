package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.testing.entity.TestingCategory;
import com.vti.testing.repository.TestingCategoryRepository;

/**
 * This class is implement TestingCategory Service.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
@Service
public class TestingCategoryServiceImpl implements TestingCategoryService {

	@Autowired
	private TestingCategoryRepository repository;

	/*
	 * @see
	 * com.vti.template.service.TestingCategoryService#getAllTestingCategories()
	 */
	@Override
	public Page<TestingCategory> getAllTestingCategories(Specification<TestingCategory> specification,
			Pageable pageable) {
		return repository.findAll(specification, pageable);
	}

	/*
	 * @see
	 * com.vti.template.service.TestingCategoryService#getTestingCategoryByID(short)
	 */
	@Override
	public TestingCategory getTestingCategoryByID(short id) {
		return repository.findById(id).get();
	}

	/*
	 * @see com.vti.template.service.TestingCategoryService#createTestingCategory(
	 * TestingCategory)
	 */
	@Override
	public void createTestingCategory(TestingCategory entity) {
		repository.save(entity);
	}

	/*
	 * @see com.vti.template.service.TestingCategoryService#updateTestingCategory(
	 * TestingCategory)
	 */
	@Override
	public void updateTestingCategory(TestingCategory entity) {
		repository.save(entity);
	}

	/*
	 * @see
	 * com.vti.template.service.TestingCategoryService#deleteTestingCategory(short)
	 */
	@Override
	public void deleteTestingCategory(short id) {
		repository.deleteById(id);
	}

	/*
	 * @see
	 * com.vti.template.service.TestingCategoryService#existsTestingCategory(short)
	 */
	@Override
	public boolean existsTestingCategory(short id) {
		return repository.existsById(id);
	}

	/*
	 * @see
	 * com.vti.template.service.TestingCategoryService#existsTestingCategory(java.
	 * lang. String)
	 */
	@Override
	public boolean existsTestingCategory(String name) {
		return repository.existsByName(name);
	}
}
