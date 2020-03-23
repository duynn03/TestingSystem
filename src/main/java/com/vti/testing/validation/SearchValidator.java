package com.vti.testing.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.vti.testing.specification.CriteriaParser;
import com.vti.testing.specification.SearchOperation;
import com.vti.testing.utils.MethodUtil;

/**
 * This class is implement logic of annotation bean validation.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 14, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 14, 2020
 */
public class SearchValidator implements ConstraintValidator<Search, String> {

	private String message;

	/*
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(Search constraintAnnotation) {

		// get default message
		message = constraintAnnotation.message();
	}

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String data, ConstraintValidatorContext context) {
		// null values are valid
		if (StringUtils.isEmpty(data)) {
			return true;
		}

		String[] tokens = data.split("\\s+");
		for (String token : tokens) {
			if (!CriteriaParser.OPERATORS.containsKey(token) && !token.equals(SearchOperation.LEFT_PARANTHESIS)
					&& !token.equals(SearchOperation.RIGHT_PARANTHESIS)) {
				if (!MethodUtil.checkRegularExpression(token, CriteriaParser.CRITERIA_REGEX)) {
					addTokenNotMatchingToDefaultMessage(context, token);
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * This method is added token not matching to default message.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param context
	 */
	private void addTokenNotMatchingToDefaultMessage(ConstraintValidatorContext context, String token) {

		message = "'" + token + "'" + " not matching.\n" + message;

		// disable existing violation message
		context.disableDefaultConstraintViolation();
		// build new violation message and add it
		context.buildConstraintViolationWithTemplate(message).addConstraintViolation();

	}
}