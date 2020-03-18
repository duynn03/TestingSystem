package com.vti.testing.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This class is api exception.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 16, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 16, 2020
 */
public class ApiError {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String detailMessage;
	private List<ApiSubError> subErrors;

	/**
	 * Constructor for class ApiError.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 16, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 16, 2020
	 */
	private ApiError() {
		timestamp = LocalDateTime.now();
	}

	/**
	 * Constructor for class ApiError.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 16, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 16, 2020
	 * @param status
	 */
	private ApiError(HttpStatus status) {
		this.status = status;
	}

	/**
	 * Constructor for class ApiError.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 16, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 16, 2020
	 * @param status
	 * @param exception
	 */
	private ApiError(HttpStatus status, Throwable exception) {
		this.status = status;
		this.message = "Unexpected error";
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * Constructor for class ApiError.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 16, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 16, 2020
	 * @param status
	 * @param message
	 * @param exception
	 */
	private ApiError(HttpStatus status, String message, Throwable exception) {
		this.status = status;
		this.message = message;
		this.detailMessage = exception.getLocalizedMessage();
	}
}
