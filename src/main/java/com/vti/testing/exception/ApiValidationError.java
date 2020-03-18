package com.vti.testing.exception;

/**
 * This class is validation error.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 16, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 16, 2020
 */
public class ApiValidationError extends ApiSubError {
	private String object;
	private String field;
	private Object rejectedValue;
	private String message;

	ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}
}
