//
package com.vti.testing.validation.form.question;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.vti.testing.form.testingcategory.QuestionCategoryForm;
import com.vti.testing.validation.group.onCreate;
import com.vti.testing.validation.group.onUpdate;

/**
 * This class is implement logic of annotation bean validation.
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Apr 3, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Apr 3, 2020
 */
public class QuestionUpdatingByQuestionCategoryValidator
		implements ConstraintValidator<QuestionUpdatingByQuestionCategory, QuestionCategoryForm> {

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(QuestionCategoryForm form, ConstraintValidatorContext context) {
		// create
		if (form.getId() == null) {
			validateCreatingForm(form);
		} else {
			// update
			validateUpdatingForm(form);
		}

		return true;
	}

	@Validated(onUpdate.class)
	private void validateUpdatingForm(@Valid QuestionCategoryForm form) {

	}

	@Validated(onCreate.class)
	private void validateCreatingForm(@Valid QuestionCategoryForm form) {

	}
}
