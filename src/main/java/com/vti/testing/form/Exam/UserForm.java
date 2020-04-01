package com.vti.testing.form.Exam;

import javax.validation.constraints.NotNull;

public class UserForm {

	@NotNull(message = "ExamForm.id.NotNull")
	private int id;

	private String userName;

	/**
	 * @return the account
	 */
	public String getuserName() {
		return userName;
	}

	/**
	 * @param account the account to set
	 */
	public UserForm setuserName(String userName) {
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
	 * @return
	 */
	public UserForm setId(int id) {
		this.id = id;
		return this;
	}

}
