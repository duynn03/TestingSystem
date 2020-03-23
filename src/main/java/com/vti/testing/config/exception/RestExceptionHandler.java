package com.vti.testing.config.exception;

import java.nio.file.AccessDeniedException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vti.testing.config.exception.customobject.ApiErrorResponse;

/**
 * This class is custom globally exception.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 19, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 19, 2020
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	// default exception
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception exception) {
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception));
	}
	
	// not found entity (getByID not found)
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException exception) {
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.NOT_FOUND, exception));
	}

	// not found url handler
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException exception, 
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.NOT_FOUND, exception));
	}
	
	// not support HTTP Method
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception, 
	  HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, exception));
	}
	
	// not support media type
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException exception, 
	  HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE, exception));
	}
	
	// BindException: This exception is thrown when fatal binding errors occur.
	// MethodArgumentNotValidException: This exception is thrown when argument annotated with @Valid failed validation:
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.BAD_REQUEST, exception));
	}

	// MissingServletRequestPartException: This exception is thrown when when the part of a multipart request not found
	// MissingServletRequestParameterException: This exception is thrown when request missing parameter:
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.BAD_REQUEST, exception));
	}

	// TypeMismatchException: This exception is thrown when try to set bean property with wrong type.
	// MethodArgumentTypeMismatchException: This exception is thrown when method argument is not the expected type:
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.BAD_REQUEST, exception));
	}

	// bean validation error
	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.BAD_REQUEST, exception));
	}

	// Spring Security
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Object> AccessDeniedException(AccessDeniedException exception) {
		// TODO Message
		return buildResponseEntity(new ApiErrorResponse(HttpStatus.FORBIDDEN, exception));
	}

	/**
	 * This method is built response entity.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param error
	 * @return
	 */
	private ResponseEntity<Object> buildResponseEntity(ApiErrorResponse error) {
		return new ResponseEntity<>(error, error.getStatus());
	}
}