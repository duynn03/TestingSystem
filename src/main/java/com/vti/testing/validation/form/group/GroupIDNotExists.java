//
package com.vti.testing.validation.form.group;

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
 * This class is . 
 * 
 * @Description: .
 * @author: NATOAN
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: NAToan
 * @modifer_date: Mar 25, 2020
 * 
 */
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, TYPE_PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { GroupIDNotExistsValidator.class })
public @interface GroupIDNotExists {
	String message()

	default "{GroupForm.id.NotExists}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload()default{};

	@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, TYPE_PARAMETER, TYPE_USE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		GroupIDNotExists[] value();

	}

}
