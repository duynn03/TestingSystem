package com.vti.testing.validation.form.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.testing.service.UserService;

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
public class UserNameNotExistsValidator implements ConstraintValidator<UserNameNotExists, Integer> {

	@Autowired
	private UserService service;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Integer data, ConstraintValidatorContext constraintValidatorContext) {

		if (data <= 0) {
			return true;
		}

		return !service.existsUser(data);
	}
}