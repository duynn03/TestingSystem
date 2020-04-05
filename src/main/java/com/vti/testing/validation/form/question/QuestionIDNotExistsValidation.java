//
package com.vti.testing.validation.form.question;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.testing.service.QuestionService;

/**
 * This class is .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Apr 1, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Apr 1, 2020
 */
public class QuestionIDNotExistsValidation implements ConstraintValidator<QuestionIDNotExists, Short> {
	@Autowired
	private QuestionService service;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Short data, ConstraintValidatorContext constraintValidatorContext) {

		if (data <= 0) {
			return true;
		}

		return !service.existsQuestion(data);
	}
}
