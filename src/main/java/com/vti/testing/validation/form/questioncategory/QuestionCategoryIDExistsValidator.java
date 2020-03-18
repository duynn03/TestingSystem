package com.vti.testing.validation.form.questioncategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.testing.service.QuestionCategoryService;

/**
 * This class is implement logic of annotation bean validation.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 8, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 8, 2020
 */
public class QuestionCategoryIDExistsValidator implements ConstraintValidator<QuestionCategoryIDExists, Short> {

	@Autowired
	private QuestionCategoryService service;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Short data, ConstraintValidatorContext constraintValidatorContext) {

		if (data <= 0) {
			return false;
		}

		return service.existsQuestionCategory(data);
	}
}