//
package com.vti.testing.validation.form.question;

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

import com.vti.testing.validation.form.questioncategory.QuestionCategoryIDNotExistsValidator;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Apr 1, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Apr 1, 2020
 */
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, TYPE_PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { QuestionCategoryIDNotExistsValidator.class })
public @interface QuestionNotExists {

}