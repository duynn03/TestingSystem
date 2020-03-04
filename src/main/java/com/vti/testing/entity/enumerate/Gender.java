package com.vti.testing.entity.enumerate;

/**
 * This class is enum gender.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 6, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 6, 2020
 */
public enum Gender {
	MALE("M"), FEMALE("F"), UNKNOW("U");

	private String code;

	/**
	 * Constructor for class Gender.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Feb 6, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Feb 6, 2020
	 * @param code
	 */
	private Gender(String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
}
