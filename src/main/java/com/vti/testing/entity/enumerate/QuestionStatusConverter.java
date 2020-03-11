//
package com.vti.testing.entity.enumerate;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class uses for Question Status .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 7, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 7, 2020
 */
@Converter(autoApply = true)
public class QuestionStatusConverter implements AttributeConverter<QuestionStatus, String> {

	/*
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public String convertToDatabaseColumn(QuestionStatus status) {
		if (status == null) {
			return QuestionStatus.DRAFT.getCode();
		}
		return status.getCode();
	}

	/*
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	@Override
	public QuestionStatus convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}
		return Stream.of(QuestionStatus.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
