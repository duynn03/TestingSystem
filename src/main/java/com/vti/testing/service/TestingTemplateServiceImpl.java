//
package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.testing.entity.Question;
import com.vti.testing.entity.Testing;
import com.vti.testing.entity.TestingCategory;
import com.vti.testing.repository.TestingTemplateRepository;

/**
 * This class is .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 17, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 17, 2020
 */
@Service
public class TestingTemplateServiceImpl implements TestingTemplateService {

	@Autowired
	TestingTemplateRepository repository;

	/*
	 * @see
	 * com.vti.testing.service.TestingTemplateService#getAllTestingTemplate(org.
	 * springframework.data.jpa.domain.Specification,
	 * org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Testing> getAllTestingTemplate( Specification<Testing> specification,
			Pageable pageable) {
		return repository.findAll(pageable);
	}

	/*
	 * @see com.vti.testing.service.TestingTemplateService#getTestingByID(short)
	 */
	@Override
	public Testing getTestingByID(short id) {
		
		return repository.findById(id).get();
	}

	/*
	 * @see
	 * com.vti.testing.service.TestingTemplateService#createTesting(com.vti.testing.
	 * entity.Testing)
	 */
	@Override
	public void createTesting(Testing entity) {
		repository.save(entity);

	}

	/*
	 * @see
	 * com.vti.testing.service.TestingTemplateService#updateTesting(com.vti.testing.
	 * entity.Testing)
	 */
	@Override
	public void updateTesting(Testing entity) {
		
		 repository.save(entity);
	}

	/*
	 * @see com.vti.testing.service.TestingTemplateService#deleteTesting(short)
	 */
	@Override
	public boolean deleteTesting(short id) {
		
		return false;
	}

	/*
	 * @see com.vti.testing.service.TestingTemplateService#existsTesting(short)
	 */
	@Override
	public boolean existsTesting(short id) {
		
		return repository.existsById(id);
	}

}
