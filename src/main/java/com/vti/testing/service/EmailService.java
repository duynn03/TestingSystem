package com.vti.testing.service;

import com.vti.testing.entity.User;

/**
 * This interface is Email Service.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 10, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 10, 2020
 */
public interface EmailService {

	/**
	 * This method is used for sending email.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 3, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 3, 2020
	 * @param recipientEmail
	 * @param subject
	 * @param content
	 * @return
	 */
	public void sendEmail(final String recipientEmail, final String subject, final String content);

	/**
	 * This method is used for sending confirm Registration User.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 3, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 3, 2020
	 * @param user
	 * @param token
	 */
	public void sendRegistrationUserConfirm(final User user, final String token);

	/**
	 * This method is used for sending reset password email.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param user
	 * @param token
	 */
	public void sendResetPassword(User user, String token);
}
