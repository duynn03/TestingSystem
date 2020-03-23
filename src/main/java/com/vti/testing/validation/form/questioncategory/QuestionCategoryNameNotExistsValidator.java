package com.vti.testing.validation.form.questioncategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

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
public class QuestionCategoryNameNotExistsValidator
		implements ConstraintValidator<QuestionCategoryNameNotExists, String> {

	@Autowired
	private QuestionCategoryService service;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String data, ConstraintValidatorContext constraintValidatorContext) {
		// null values are valid
		if (StringUtils.isEmpty(data)) {
			return true;
		}

		return !service.existsQuestionCategory(data);
	}
}