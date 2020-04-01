package com.vti.testing.dto;

import com.vti.testing.entity.enumerate.UserStatus;

/**
 * This class is UserDto.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 10, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 10, 2020
 */
public class UserDto {

	private int id;
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
	 * @return 
	 */
	public UserDto setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	public void setStatus(UserStatus status) {
		this.status = status;
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
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
