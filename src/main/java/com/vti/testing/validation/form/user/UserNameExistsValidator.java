package com.vti.testing.validation.form.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

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
public class UserNameExistsValidator implements ConstraintValidator<UserNameExists, String> {

	@Autowired
	private UserService service;

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

		return service.existsByUserName(data);
	}
}