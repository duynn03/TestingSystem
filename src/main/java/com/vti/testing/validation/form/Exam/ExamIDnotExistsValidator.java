package com.vti.testing.validation.form.Exam;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.testing.service.ExamServiceImpl;

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
public class ExamIDnotExistsValidator implements ConstraintValidator<ExamIDnotExists, Integer> {

	@Autowired
	private ExamServiceImpl service;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Integer data, ConstraintValidatorContext constraintValidatorContext) {

		if (data <= 0) {
			return false;
		}

		return !service.existsExamByID(data);
	}
}