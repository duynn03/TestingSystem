package com.vti.testing.entity.enumerate;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class uses for Role convertation.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 6, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 6, 2020
 */
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

	/*
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public String convertToDatabaseColumn(Role role) {
		if (role == null) {
			return Role.EMPLOYEE.getCode();
		}
		return role.getCode();
	}

	/*
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	@Override
	public Role convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}
		return Stream.of(Role.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
