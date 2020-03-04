package com.vti.testing.entity.enumerate;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class uses for gender convertation.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 6, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 6, 2020
 */
@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {

	/*
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public String convertToDatabaseColumn(Gender gender) {
		if (gender == null) {
			return null;
		}
		return gender.getCode();
	}

	/*
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	@Override
	public Gender convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}
		return Stream.of(Gender.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
