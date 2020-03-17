//
package com.vti.testing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.testing.entity.Question;
import com.vti.testing.entity.enumerate.QuestionStatus;
import com.vti.testing.repository.QuestionRepository;

/**
 * This class is .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 5, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 5, 2020
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository repository;

	/*
	 * @see
	 * com.vti.testing.service.QuestionService#getAllQuestion(org.springframework.
	 * data.domain.Pageable)
	 */
	@Override
	public Page<Question> getAllQuestion(Pageable pageable) {

		return repository.findAll(pageable);

	}

	/*
	 * @see
	 * com.vti.testing.service.QuestionService#createQuestion(com.vti.testing.entity
	 * .Question)
	 */
	@Override
	public void createQuestion(Question entity) {

		repository.save(entity);
	}

	/*
	 * @see com.vti.testing.service.QuestionService#getQuestionByID(short)
	 */
	@Override
	public Question getQuestionByID(short id) {

		return repository.findById(id).get();
	}

	/*
	 * @see com.vti.testing.service.QuestionService#updateQuestion(short,
	 * com.vti.testing.form.QuestionForm)
	 */
	@Override
	public void updateQuestion(Question entity) {

		repository.save(entity);

	}

	/*
	 * @see com.vti.testing.service.QuestionService#deleteQuestion(short)
	 */
	@Override
	public boolean deleteQuestion(short id) {

		if (repository.findById(id).get().getStatus() != QuestionStatus.PUBLISHED
				&& null == repository.findById(id).get().getQuestionCategory()
				&& null == repository.findById(id).get().getAnswers()) {
			repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * @see com.vti.testing.service.QuestionService#existsQuestion(short)
	 */
	@Override
	public boolean existsQuestion(short id) {
		return repository.existsById(id);

	}

	/*
	 * @see com.vti.testing.service.QuestionService#existsQuestion(java.lang.String)
	 */
	// @Override
	// public boolean existsQuestion(String name) {
	// return repository.existsByName(name);

	// }

}
