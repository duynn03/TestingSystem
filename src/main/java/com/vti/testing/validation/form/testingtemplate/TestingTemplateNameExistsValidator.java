//
package com.vti.testing.validation.form.testingtemplate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.testing.service.TestingTemplateService;
import com.vti.testing.validation.form.Exam.ExamNamenotExists;

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
public class TestingTemplateNameExistsValidator implements ConstraintValidator<ExamNamenotExists, String>  {

	TestingTemplateService service;
	/* 
	* @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	*/
	@Override
	public boolean isValid(String data, ConstraintValidatorContext context) {
		if (data == null) {
			return false;
		}

		return service.existsTestingTemplateByName(data);
	}

}
