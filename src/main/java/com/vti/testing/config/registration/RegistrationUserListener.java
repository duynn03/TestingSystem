package com.vti.testing.config.registration;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.vti.testing.entity.RegistrationUserToken;
import com.vti.testing.entity.User;
import com.vti.testing.service.EmailService;
import com.vti.testing.service.UserService;

/**
 * This class is used for handling Registration User complete.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Apr 3, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Apr 3, 2020
 */
@Component
public class RegistrationUserListener implements ApplicationListener<OnRegistrationUserCompleteEvent> {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	/*
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.
	 * springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(final OnRegistrationUserCompleteEvent event) {
		this.confirmRegistration(event);
	}

	/**
	 * This method is used for confirm registration.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 * @param event
	 */
	private void confirmRegistration(final OnRegistrationUserCompleteEvent event) {

		// extract all User information
		final User user = event.getUser();

		// create token for confirm Registration
		final String token = UUID.randomUUID().toString();

		userService.createToken(new RegistrationUserToken().setToken(token).setUser(user));

		// send mail
		emailService.sendConfirmRegistrationUser(user, token);
	}

}
