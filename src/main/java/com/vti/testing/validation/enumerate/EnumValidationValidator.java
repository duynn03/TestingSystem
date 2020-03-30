package com.vti.testing.validation.enumerate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

/**
 * This class is implement logic of annotation bean validation.
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Feb 8, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Feb 8, 2020
 */
public class EnumValidationValidator implements ConstraintValidator<EnumValidation, String> {

	private List<String> acceptedValues;

	@Override
	public void initialize(EnumValidation annotation) {
		acceptedValues = Stream.of(annotation.enumClass().getEnumConstants()).map(Enum::name)
				.collect(Collectors.toList());
	}

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String data, ConstraintValidatorContext constraintValidatorContext) {

		if (StringUtils.isEmpty(data)) {
			return true;
		}

		return acceptedValues.contains(data);
	}
}