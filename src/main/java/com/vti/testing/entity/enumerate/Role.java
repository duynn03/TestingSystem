package com.vti.testing.entity.enumerate;

/**
 * This class is enum role.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 6, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 6, 2020
 */
public enum Role {
	ADMIN("Admin"), EMPLOYEE("Employee"), MANAGER("Manager");

	private String code;

	/**
	 * Constructor for class Role.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Feb 6, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Feb 6, 2020
	 * @param code
	 */
	private Role(String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
}
