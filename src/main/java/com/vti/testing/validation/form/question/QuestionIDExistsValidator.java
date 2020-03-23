//
package com.vti.testing.validation.form.question;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.testing.service.QuestionService;

/**
 *This class is implement logic of annotation bean validation.
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 21, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 21, 2020
 */
public class QuestionIDExistsValidator implements ConstraintValidator<QuestionIDExists, Short>{

	@Autowired
	private QuestionService service;
	/* 
	* @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	*/
	@Override
	public boolean isValid(Short data, ConstraintValidatorContext context) {
		if (data <= 0) {
			return false;
		}

		return service.existsQuestion(data);
	}

}
