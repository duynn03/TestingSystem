package com.vti.testing.entity.enumerate;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class uses for Question Type.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 6, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 6, 2020
 */
@Converter(autoApply = true)
public class QuestionTypeConverter implements AttributeConverter<QuestionType, String> {

	/*
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public String convertToDatabaseColumn(QuestionType type) {
		if (type == null) {
			return QuestionType.MULTIPLE_CHOICE.getCode();
		}
		return type.getCode();
	}

	/*
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	@Override
	public QuestionType convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}
		return Stream.of(QuestionType.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
