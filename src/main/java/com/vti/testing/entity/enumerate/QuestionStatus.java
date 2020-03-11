package com.vti.testing.entity.enumerate;

/**
 * This class is enum status of question.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 6, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 6, 2020
 */
public enum QuestionStatus {
	DRAFT("0"), PUBLISHED("1");

	private String code;

	/**
	 * Constructor for class QuestionStatus.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 7, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 7, 2020
	 * @param string
	 */
	QuestionStatus(String code) {
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
	public QuestionStatus setCode(String code) {
		this.code = code;
		return this;
	}

}
