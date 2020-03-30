package com.vti.testing.validation.form.user;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * This interface is a annotation bean validation.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 8, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 8, 2020
 */
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, TYPE_PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { UserNameNotExistsValidator.class })
public @interface UserNameNotExists {

	String message() default "{UserForm.userName.NotExists}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, TYPE_PARAMETER, TYPE_USE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		UserNameNotExists[] value();
	}
}