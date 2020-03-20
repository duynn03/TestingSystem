package com.vti.testing.exception.customobject.validation;

/**
 * This class is error validation .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 19, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 19, 2020
 */
public class Validation {

	private String object;
	private String field;
	private Object rejectedValue;
	private String message;

	/**
	 * Constructor for class Validation.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param object
	 * @param field
	 * @param rejectedValue
	 * @param message
	 */
	public Validation(String object, String field, Object rejectedValue, String message) {
		this.object = object;
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @return the rejectedValue
	 */
	public Object getRejectedValue() {
		return rejectedValue;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}
}
