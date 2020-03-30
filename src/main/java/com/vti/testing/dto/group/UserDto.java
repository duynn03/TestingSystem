//
package com.vti.testing.dto.group;

import com.vti.testing.entity.enumerate.UserStatus;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NATOAN
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NAToan
 * @modifer_date: Mar 12, 2020
 */
public class UserDto {

	private int id;
	private String account;
	private String fullName;
	private UserStatus status;

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
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
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

}
