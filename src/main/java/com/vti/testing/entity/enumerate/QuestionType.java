package com.vti.testing.entity.enumerate;

/**
 * This class is enum Question Type.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 6, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 6, 2020
 */
public enum QuestionType {
	MULTIPLE_CHOICE("Multiple-Choice"), ESSAY("Essay");

	private String code;

	/**
	 * Constructor for class Question Type.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Feb 6, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Feb 6, 2020
	 * @param code
	 */
	private QuestionType(String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public QuestionType setCode(String code) {
		this.code = code;
		return this;
	}

}
