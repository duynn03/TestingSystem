package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.testing.entity.QuestionCategory;
import com.vti.testing.repository.QuestionCategoryRepository;

/**
 * This class is implement QuestionCategory Service.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
@Service
public class QuestionCategoryServiceImpl implements QuestionCategoryService {

	@Autowired
	private QuestionCategoryRepository repository;

	/*
	 * @see
	 * com.vti.template.service.QuestionCategoryService#getAllQuestionCategories()
	 */
	@Override
	public Page<QuestionCategory> getAllQuestionCategories(Specification<QuestionCategory> specification,
			Pageable pageable) {
		return repository.findAll(specification, pageable);
	}

	/*
	 * @see
	 * com.vti.template.service.QuestionCategoryService#getQuestionCategoryByID(
	 * short)
	 */
	@Override
	public QuestionCategory getQuestionCategoryByID(short id) {
		return repository.findById(id).get();
	}

	/*
	 * @see com.vti.template.service.QuestionCategoryService#createQuestionCategory(
	 * QuestionCategory)
	 */
	@Override
	public void createQuestionCategory(QuestionCategory entity) {
		repository.save(entity);
	}

	/*
	 * @see com.vti.template.service.QuestionCategoryService#updateQuestionCategory(
	 * QuestionCategory)
	 */
	@Override
	public void updateQuestionCategory(QuestionCategory entity) {
		repository.save(entity);
	}

	/*
	 * @see com.vti.template.service.QuestionCategoryService#deleteQuestionCategory(
	 * short)
	 */
	@Override
	public void deleteQuestionCategory(short id) {
		repository.deleteById(id);
	}

	/*
	 * @see com.vti.template.service.QuestionCategoryService#existsQuestionCategory(
	 * short)
	 */
	@Override
	public boolean existsQuestionCategory(short id) {
		return repository.existsById(id);
	}

	/*
	 * @see
	 * com.vti.template.service.QuestionCategoryService#existsQuestionCategory(java.
	 * lang. String)
	 */
	@Override
	public boolean existsQuestionCategory(String name) {
		return repository.existsByName(name);
	}
}
