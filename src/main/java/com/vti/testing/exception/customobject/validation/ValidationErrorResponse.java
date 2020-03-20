package com.vti.testing.exception.customobject.validation;

import java.util.ArrayList;
import java.util.List;

import com.vti.testing.exception.customobject.ErrorResponse;

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
public class ValidationErrorResponse extends ErrorResponse {

	private List<Validation> validations;

	/**
	 * Constructor for class ValidationResponse.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 */
	public ValidationErrorResponse() {
		validations = new ArrayList<>();
	}

	/**
	 * This method is added validation to response.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param validation
	 */
	public void addValidation(Validation validation) {
		validations.add(validation);
	}

	/**
	 * This method is added validation to response.
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
	public void addValidation(String object, String field, Object rejectedValue, String message) {
		validations.add(new Validation(object, field, rejectedValue, message));
	}

	/**
	 * @return the validations
	 */
	public List<Validation> getValidations() {
		return validations;
	}
}
