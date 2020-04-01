//
package com.vti.testing.validation.form.group;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.testing.service.GroupService;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: NATOAN
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: NAToan
 * @modifer_date: Mar 25, 2020
 */
public class GroupIDNotExistsValidator implements ConstraintValidator<GroupIDNotExists, Integer>{

	@Autowired
	private GroupService service;
	/**
	 * 
	 */
	@Override
	public boolean isValid(Integer data, ConstraintValidatorContext constraintValidatorContext) {

		if (data <= 0) {
			return true;
		}

		return !service.existsGroup(data);
	}
}