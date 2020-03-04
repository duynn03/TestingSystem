package com.vti.testing.entity.enumerate;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class uses for Generation Type.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 6, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 6, 2020
 */
@Converter(autoApply = true)
public class GenerationTypeTestingConverter implements AttributeConverter<GenerationTypeTesting, String> {

	/*
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public String convertToDatabaseColumn(GenerationTypeTesting type) {
		if (type == null) {
			return null;
		}
		return type.getCode();
	}

	/*
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	@Override
	public GenerationTypeTesting convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}
		return Stream.of(GenerationTypeTesting.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
