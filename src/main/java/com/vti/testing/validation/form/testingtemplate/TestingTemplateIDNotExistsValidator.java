//
package com.vti.testing.validation.form.testingtemplate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.testing.service.TestingTemplateService;
import com.vti.testing.validation.form.testingcategory.TestingCategoryIDNotExists;

/**
 * This class is .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Apr 3, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Apr 3, 2020
 */
public class TestingTemplateIDNotExistsValidator implements ConstraintValidator<TestingCategoryIDNotExists, Short> {

	@Autowired
	private TestingTemplateService service;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Short data, ConstraintValidatorContext context) {
		if (data <= 0) {
			return true;
		}

		return !service.existsTestingByID(data);
	}

}
