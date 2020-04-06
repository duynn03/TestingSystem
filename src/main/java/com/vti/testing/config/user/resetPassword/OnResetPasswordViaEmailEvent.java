package com.vti.testing.config.user.resetPassword;

import org.springframework.context.ApplicationEvent;

/**
 * This class is Reset User's Password Event.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Apr 2, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Apr 2, 2020
 */
public class OnResetPasswordViaEmailEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private String email;

	/**
	 * Constructor for class OnResetPasswordViaEmailEvent.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 * @param user
	 * @param appUrl
	 */
	public OnResetPasswordViaEmailEvent(String email) {
		super(email);
		this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
