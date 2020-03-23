package com.vti.testing.validation.form.testingcategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vti.testing.service.TestingCategoryService;

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
public class TestingCategoryNameNotExistsValidator
		implements ConstraintValidator<TestingCategoryNameNotExists, String> {

	@Autowired
	private TestingCategoryService service;

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

		return !service.existsTestingCategory(data);
	}
}