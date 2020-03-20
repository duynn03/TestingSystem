package com.vti.testing.exception.customobject;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.testing.exception.customobject.validation.ValidationErrorResponse;

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
public class ApiErrorResponse {

	private HttpStatus status;

	private String message;

	private String detailMessage;

	private ErrorResponse errorResponse;

	/**
	 * Constructor for class ApiErrorResponse.
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
	public ApiErrorResponse(HttpStatus status, Exception exception) {
		this.status = status;
		this.message = "Unexpected error";
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * Constructor for class ApiErrorResponse.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param status
	 * @param exception
	 */
	public ApiErrorResponse(HttpStatus status, EntityNotFoundException exception) {
		this.status = status;
		this.message = "Not Found Entity";
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * Constructor for class ApiErrorResponse.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param status
	 * @param exception
	 */
	public ApiErrorResponse(HttpStatus status, NoHandlerFoundException exception) {
		this.status = status;
		this.message = "No handler found for " + exception.getHttpMethod() + " " + exception.getRequestURL();
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * Constructor for class ApiErrorResponse.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 20, 2020
	 * @param status
	 * @param exception
	 */
	public ApiErrorResponse(HttpStatus status, HttpRequestMethodNotSupportedException exception) {
		this.status = status;
		this.message = getMessageFromHttpRequestMethodNotSupportedException(exception);
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * This method is getted message from exception.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 20, 2020
	 * @param exception
	 * @return
	 */
	private String getMessageFromHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException exception) {
		String message = exception.getMethod() + " method is not supported for this request. Supported methods are ";
		for (HttpMethod method : exception.getSupportedHttpMethods()) {
			message += method + " ";
		}
		return message;
	}

	/**
	 * Constructor for class ApiErrorResponse.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 20, 2020
	 * @param status
	 * @param exception
	 */
	public ApiErrorResponse(HttpStatus status, HttpMediaTypeNotSupportedException exception) {
		this.status = status;
		this.message = getMessageFromHttpMediaTypeNotSupportedException(exception);
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * This method is getted message from exception.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 20, 2020
	 * @param exception
	 * @return
	 */
	private String getMessageFromHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
		String message = exception.getContentType() + " media type is not supported. Supported media types are ";
		for (MediaType method : exception.getSupportedMediaTypes()) {
			message += method + ", ";
		}
		return message.substring(0, message.length() - 2);
	}

	/**
	 * Constructor for class ApiErrorResponse.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param status
	 * @param exception
	 */
	public ApiErrorResponse(HttpStatus status, ConstraintViolationException exception) {
		this.status = status;
		this.message = "Validation: Parameter is error!";
		handleConstraintViolationException(exception);
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * This method is handle exception.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param exception
	 * @return
	 */
	private void handleConstraintViolationException(ConstraintViolationException exception) {
		ValidationErrorResponse validationResponse = new ValidationErrorResponse();

		// parse exception to List Validation
		for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
			validationResponse.addValidation(violation.getRootBeanClass().getName(),
					violation.getPropertyPath().toString(), violation.getInvalidValue(), violation.getMessage());
		}

		this.errorResponse = validationResponse;
	}

	/**
	 * Constructor for class ApiErrorResponse.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param status
	 * @param exception
	 */
	public ApiErrorResponse(HttpStatus status, MethodArgumentNotValidException exception) {
		this.status = status;
		this.message = "Validation: Method argument not valid!";
		handleMethodArgumentNotValidException(exception);
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * This method is handle exception.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param exception
	 */
	private void handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		ValidationErrorResponse validationResponse = new ValidationErrorResponse();

		// parse exception to List Validation
		for (ObjectError error : exception.getBindingResult().getAllErrors()) {
			validationResponse.addValidation(error.getObjectName(), null, null, error.getDefaultMessage());
		}
	}

	/**
	 * Constructor for class ApiErrorResponse.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param status
	 * @param exception
	 */
	public ApiErrorResponse(HttpStatus status, MissingServletRequestParameterException exception) {
		this.status = status;
		this.message = exception.getParameterName() + " parameter is missing";
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * Constructor for class ApiErrorResponse.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param status
	 * @param exception
	 */
	public ApiErrorResponse(HttpStatus status, MethodArgumentTypeMismatchException exception) {
		this.status = status;
		this.message = exception.getName() + " should be of type " + exception.getRequiredType().getName();
		this.detailMessage = exception.getLocalizedMessage();
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @return the timestamp
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	public LocalDateTime getTimestamp() {
		return LocalDateTime.now();
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the detailMessage
	 */
	public String getDetailMessage() {
		return detailMessage;
	}

	/**
	 * @return the errorResponse
	 */
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

}
