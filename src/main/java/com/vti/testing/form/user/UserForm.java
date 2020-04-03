/**
 * 
 */
package com.vti.testing.form.user;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.vti.testing.validation.form.user.EmailNotExists;
import com.vti.testing.validation.form.user.UserNameNotExists;
import com.vti.testing.validation.group.onCreate;
import com.vti.testing.validation.group.onUpdate;

import io.swagger.annotations.ApiModelProperty;

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

public class UserForm {

	@ApiModelProperty(notes = "The User's userName")
	@NotEmpty(message = "{UserForm.userName.NotEmpty}", groups = onCreate.class)
	@UserNameNotExists(groups = onCreate.class)
	@Size(min = 6, max = 50, message = "{UserForm.userName.Size}", groups = onCreate.class)
	@Null(message = "{UserForm.userName.Null}", groups = onUpdate.class)
	private String userName;

	@ApiModelProperty(notes = "The User's Email")
	@NotEmpty(message = "{UserForm.email.NotEmpty}", groups = { onCreate.class, onUpdate.class })
	@Size(min = 6, max = 50, message = "{UserForm.email.Size}", groups = { onCreate.class, onUpdate.class })
	@EmailNotExists(groups = { onCreate.class})
	private String email;

	@ApiModelProperty(notes = "The User's Password")
	@NotEmpty(message = "{UserForm.password.NotEmpty}", groups = { onCreate.class, onUpdate.class })
	@Size(max = 50, message = "{UserForm.password.Size}", groups = { onCreate.class, onUpdate.class })
	private String password;

	@ApiModelProperty(notes = "The User's Gender")
	@NotEmpty(message = "UserForm.gender.NotEmpty", groups = { onCreate.class, onUpdate.class })
	private String gender;

	@ApiModelProperty(notes = "The User's FirstName")
	@NotEmpty(message = "{UserForm.firstName.NotEmpty}", groups = { onCreate.class, onUpdate.class })
	@Size(max = 50, message = "{UserForm.firstName.Size}", groups = { onCreate.class, onUpdate.class })
	private String firstName;

	@ApiModelProperty(notes = "The User's LastName")
	@NotEmpty(message = "{UserForm.lastName.NotEmpty}", groups = { onCreate.class, onUpdate.class })
	@Size(max = 50, message = "{UserForm.lastName.Size}", groups = { onCreate.class, onUpdate.class })
	private String lastName;

	@ApiModelProperty(notes = "The User's Birthday")
	@Past(message = "{UserForm.birthday}", groups = { onCreate.class, onUpdate.class })
	private Date birthday;

	@ApiModelProperty(notes = "The User's Address")
	@NotEmpty(message = "{UserForm.address.NotEmpty}", groups = { onCreate.class, onUpdate.class })
	@Size(max = 100, message = "{UserForm.address.Size}", groups = { onCreate.class, onUpdate.class })
	private String address;

	@ApiModelProperty(notes = "The User's Phone")
	@NotEmpty(message = "{UserForm.phone.NotEmpty}", groups = { onCreate.class, onUpdate.class })
	@Size(min = 9, max = 15, message = "{UserForm.phone.Size}", groups = { onCreate.class, onUpdate.class })
	private String phone;

	@ApiModelProperty(notes = "The User's Role")
	@NotEmpty(message = "UserForm.role.NotEmpty", groups = { onCreate.class, onUpdate.class })
	private String role;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public UserForm setUserName(String userName) {
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
	public UserForm setEmail(String email) {
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
	public UserForm setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public UserForm setGender(String gender) {
		this.gender = gender;
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
	public UserForm setFirstName(String firstName) {
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
	public UserForm setLastName(String lastName) {
		this.lastName = lastName;
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
	public UserForm setBirthday(Date birthday) {
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
	public UserForm setAddress(String address) {
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
	public UserForm setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public UserForm setRole(String role) {
		this.role = role;
		return this;
	}

}
