package com.vti.testing.config.resourceproperties.user;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Apr 5, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Apr 5, 2020
 */
@ConfigurationProperties(prefix = "user.resetpassword.token")
public class ResetPasswordTokenProperty {

	private long expirationTime;

	/**
	 * @return the expirationTime
	 */
	public long getExpirationTime() {
		return expirationTime;
	}

	/**
	 * @param expirationTime the expirationTime to set
	 */
	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}

}
