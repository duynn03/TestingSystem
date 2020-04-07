/**
 * 
 */
package com.vti.testing.dto.questioncategory;

import com.vti.testing.entity.enumerate.UserStatus;

/**
 * This class is Userdto.
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Apr 7, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Apr 7, 2020
 */

public class UserDto {
	private String userName;
	private String fullName;
	private UserStatus status;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public UserDto setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public UserDto setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	/**
	 * @return the status
	 */
	public UserStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public UserDto setStatus(UserStatus status) {
		this.status = status;
		return this;
	}

}
