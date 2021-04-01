package com.vti.testing.config.resourceproperties.registration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is Registration Token User property.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Apr 3, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Apr 3, 2020
 */
@ConfigurationProperties(prefix = "user.registration.token")
public class RegistrationUserTokenProperty {

	private long expirationTime;

	/**
	 * Constructor for class RegistrationUserTokenProperty.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 3, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 3, 2020
	 */
	public RegistrationUserTokenProperty() {
	}

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
