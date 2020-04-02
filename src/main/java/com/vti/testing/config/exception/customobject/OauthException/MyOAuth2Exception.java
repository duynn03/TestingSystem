package com.vti.testing.config.exception.customobject.OauthException;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * This class is MyOAuth2 Exception.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 23, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 23, 2020
 */
@JsonSerialize(using = MyOAuthExceptionJacksonSerializer.class)
public class MyOAuth2Exception extends OAuth2Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for class MyOAuth2Exception.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 23, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 23, 2020
	 * @param msg
	 * @param t
	 */
	public MyOAuth2Exception(String msg, Throwable t) {
		super(msg, t);
	}

	public MyOAuth2Exception(String msg) {
		super(msg);

	}

}
