/**
 * 
 */
package com.vti.testing.dto.user;

import com.vti.testing.entity.enumerate.Gender;
import com.vti.testing.entity.enumerate.Role;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Mar 25, 2020
 */

public class UserDto {
	private String userName;
	private String email;
	private String fullname;
	private String birthday;
	private String address;
	private String phone;
	private Gender gender;
	private Role role;

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public UserDto setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public UserDto setFullname(String fullname) {
		this.fullname = fullname;
		return this;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public UserDto setGender(Gender gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public UserDto setRole(Role role) {
		this.role = role;
		return this;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public UserDto setBirthday(String birthday) {
		this.birthday = birthday;
		return this;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public UserDto setAddress(String address) {
		this.address = address;
		return this;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public UserDto setPhone(String phone) {
		this.phone = phone;
		return this;
	}

}
