package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vti.testing.config.internationalization.MessageProperty;
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
	public void sendConfirmRegistrationUser(User user, String token) {

		final String confirmationUrl = "http://localhost:8080/api/v1/Users/registrationConfirm/" + token;

		sendEmail(user.getEmail(), messageProperty.getMessage("Email.subject"),
				messageProperty.getMessage("Email.message") + " \r\n" + confirmationUrl);

	}

}
