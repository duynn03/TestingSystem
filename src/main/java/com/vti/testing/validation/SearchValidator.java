package com.vti.testing.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.vti.testing.specification.CriteriaParser;
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

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String data, ConstraintValidatorContext constraintValidatorContext) {
		// null values are valid
		if (StringUtils.isEmpty(data)) {
			return true;
		}

		return MethodUtil.checkRegularExpression(data, CriteriaParser.CRITERIA_REGEX);

	}
}