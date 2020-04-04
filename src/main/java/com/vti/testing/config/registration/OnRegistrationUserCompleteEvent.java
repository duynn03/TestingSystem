package com.vti.testing.config.registration;

import org.springframework.context.ApplicationEvent;

import com.vti.testing.entity.User;

/**
 * This class is Registration User Complete Event.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Apr 2, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Apr 2, 2020
 */
public class OnRegistrationUserCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private User user;

	/**
	 * Constructor for class OnRegistrationUserCompleteEvent.
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
	public OnRegistrationUserCompleteEvent(User user) {
		super(user);
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
