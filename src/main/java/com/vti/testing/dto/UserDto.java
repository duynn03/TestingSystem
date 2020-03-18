/**
 * 
 */
package com.vti.testing.dto;

import java.util.Date;

import com.vti.testing.entity.enumerate.Gender;
import com.vti.testing.entity.enumerate.Role;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Mar 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Mar 6, 2020
 */

public class UserDto {
	private int id;
	private String userName;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date birthday;
	private String address;
	private String phone;
	private Role role;

	/**
	 * @return the account
	 */
	public String getuserName() {
		return userName;
	}

	/**
	 * @param account the account to set
	 */
	public UserDto setuserName(String userName) {
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public UserDto setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public UserDto setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public UserDto setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public UserDto setBirthday(Date birthday) {
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 * @return 
	 */
	public UserDto setId(int id) {
		this.id = id;
		return this;
	}

}
