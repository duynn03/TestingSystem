package com.vti.testing.config.user.resetPassword;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.vti.testing.entity.ResetPasswordToken;
import com.vti.testing.entity.User;
import com.vti.testing.service.EmailService;
import com.vti.testing.service.UserService;

/**
 * This class is used for Reset User's Password.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Apr 3, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Apr 3, 2020
 */
@Component
public class ResetPasswordViaEmailListener implements ApplicationListener<OnResetPasswordViaEmailEvent> {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	/*
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.
	 * springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(final OnResetPasswordViaEmailEvent event) {
		this.resetPassword(event);
	}

	/**
	 * This method is used for resetting password.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 * @param event
	 */
	private void resetPassword(final OnResetPasswordViaEmailEvent event) {

		// extract all User information
		final User user = userService.getUserByEmail(event.getEmail());

		// delete old token
		userService.deleteResetPasswordTokenByUserId(user.getId());

		// create new token for resetting password
		final String token = UUID.randomUUID().toString();
		userService.createResetPasswordToken(new ResetPasswordToken().setToken(token).setUser(user));

		// send mail
		emailService.sendResetPassword(user, token);
	}

}
