package com.vti.testing.entity.enumerate;

/**
 * This class is enum Generation Type.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 6, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 6, 2020
 */
public enum GenerationTypeTesting {
	RANDOM("Random"), CUSTOM("Custom");

	private String code;

	/**
	 * Constructor for class Generation Type.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Feb 6, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Feb 6, 2020
	 * @param code
	 */
	private GenerationTypeTesting(String code) {
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
	public GenerationTypeTesting setCode(String code) {
		this.code = code;
		return this;
	}

}
