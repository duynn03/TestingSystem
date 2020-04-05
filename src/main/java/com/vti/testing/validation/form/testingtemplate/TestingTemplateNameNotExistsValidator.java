//
package com.vti.testing.validation.form.testingtemplate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.testing.service.TestingTemplateService;

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
public class TestingTemplateNameNotExistsValidator
		implements ConstraintValidator<TestingTemplateNameNotExists, String> {
	@Autowired
	TestingTemplateService service;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String data, ConstraintValidatorContext constraintValidatorContext) {
		if (data == null) {
			return false;
		}

		return !service.existsTestingTemplateByName(data);
	}

}
