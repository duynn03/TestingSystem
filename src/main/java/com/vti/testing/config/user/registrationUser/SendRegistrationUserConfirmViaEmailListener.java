package com.vti.testing.config.user.registrationUser;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.vti.testing.entity.RegistrationUserToken;
import com.vti.testing.entity.User;
import com.vti.testing.service.EmailService;
import com.vti.testing.service.UserService;

/**
 * This class is used for handling send Registration User confirm.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Apr 3, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Apr 3, 2020
 */
@Component
public class SendRegistrationUserConfirmViaEmailListener
		implements ApplicationListener<OnSendRegistrationUserConfirmViaEmailEvent> {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	/*
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.
	 * springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(final OnSendRegistrationUserConfirmViaEmailEvent event) {
		this.sendRegistrationConfirm(event);
	}

	/**
	 * This method is used for send registration confirm.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 * @param event
	 */
	private void sendRegistrationConfirm(final OnSendRegistrationUserConfirmViaEmailEvent event) {

		// extract all User information
		final User user = userService.getUserByEmail(event.getEmail());

		// delete old token
		userService.deleteRegistrationUserTokenByUserId(user.getId());

		// create new token for confirm Registration
		final String newToken = UUID.randomUUID().toString();
		userService.createRegistrationUserToken(new RegistrationUserToken().setToken(newToken).setUser(user));

		// send mail
		emailService.sendRegistrationUserConfirm(user, newToken);
	}

}
