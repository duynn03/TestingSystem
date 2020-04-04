package com.vti.testing.config.resourceproperties.registration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is email property.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 27, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 27, 2020
 */
@ConfigurationProperties(prefix = "spring.mail")
public class EmailProperty {

	private String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
