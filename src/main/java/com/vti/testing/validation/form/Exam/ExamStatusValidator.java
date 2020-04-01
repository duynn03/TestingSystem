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
public class ExamStatusValidator implements ConstraintValidator<ExamIDExists, Integer> {

	@Autowired
	private ExamServiceImpl service;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Integer data, ConstraintValidatorContext constraintValidatorContext) {

		if (data == null) {
			return false;
		}

		return service.getExamById(data).getStatus().toString().equals("DRAFT");
	}
}