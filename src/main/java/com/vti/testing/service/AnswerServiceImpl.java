//
package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.vti.testing.entity.Answer;
import com.vti.testing.repository.AnswerRepository;

/**
 * This class is .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 24, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 24, 2020
 */
@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository repository;

	/*
	 * @see
	 * com.vti.testing.service.AnswerService#createQuestionCategory(com.vti.testing.
	 * entity.Answer)
	 */
	@Override
	public void createAnswer(Answer entity) {

		repository.save(entity);
	}

}
