package com.vti.testing.validation.form.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.vti.testing.config.internationalization.MessageProperty;
import com.vti.testing.form.user.UserForm;
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
public class UserFormUpdateValidator implements ConstraintValidator<UserFormUpdate, Object[]> {

	@Autowired
	private UserService service;

	@Autowired
	private MessageProperty messageProperty;

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Object[] params, ConstraintValidatorContext context) {

		/*
		 * if (form == null) { addExceptionMessage(context,
		 * messageProperty.getExceptionMessageFromPropertiesFile("UserForm.NotNull"));
		 * return false; }
		 */

		//form.get
		//return !service.existsByEmail(data);
		 
		 int id = (@UserIDExists int) params[0];
		 
		return true;
	}

	/**
	 * This method is added exception messages.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param context
	 * @param message
	 */
	private void addExceptionMessage(ConstraintValidatorContext context, String message) {
		// disable existing violation message
		context.disableDefaultConstraintViolation();
		// build new violation message and add it
		context.buildConstraintViolationWithTemplate(message).addConstraintViolation();

	}
}