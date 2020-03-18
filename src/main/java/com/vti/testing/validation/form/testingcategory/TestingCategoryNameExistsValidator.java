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
public class TestingCategoryNameExistsValidator implements ConstraintValidator<TestingCategoryNameExists, String> {

	@Autowired
	private TestingCategoryService service;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String data, ConstraintValidatorContext constraintValidatorContext) {
		// null values aren't valid
		if (StringUtils.isEmpty(data)) {
			return false;
		}

		return service.existsTestingCategory(data);
	}
}