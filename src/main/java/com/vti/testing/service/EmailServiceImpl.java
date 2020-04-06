package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vti.testing.config.internationalization.MessageProperty;
import com.vti.testing.config.resourceproperties.ServerProperty;
import com.vti.testing.entity.User;

/**
 * This class is implement Email Service.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 10, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 10, 2020
 */
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MessageProperty messageProperty;

	@Autowired
	private ServerProperty serverProperty;

	/*
	 * @see com.vti.testing.service.EmailService#sendEmail(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void sendEmail(final String recipientEmail, final String subject, final String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipientEmail);
		message.setSubject(subject);
		message.setText(content);

		mailSender.send(message);
	}

	/*
	 * @see
	 * com.vti.testing.service.EmailService#sendConfirmRegistrationUser(com.vti.
	 * testing.entity.User, java.lang.String)
	 */
	@Override
	public void sendRegistrationUserConfirm(User user, String token) {

		String confirmationUrl = serverProperty.getUrl() + "/api/v1/Users/activeUser?token=" + token;

		sendEmail(user.getEmail(), messageProperty.getMessage("Email.registrationUser.subject"),
				messageProperty.getMessage("Email.registrationUser.message") + " \r\n" + confirmationUrl);

	}

	/*
	 * @see
	 * com.vti.testing.service.EmailService#sendResetPassword(com.vti.testing.entity
	 * .User, java.lang.String)
	 */
	@Override
	public void sendResetPassword(User user, String token) {
		String confirmationUrl = serverProperty.getUrl() + "/api/v1/Users/resetPassword?token=" + token;

		sendEmail(user.getEmail(), messageProperty.getMessage("Email.resetPassword.subject"),
				messageProperty.getMessage("Email.resetPassword.message") + " \r\n" + confirmationUrl);

	}

}
