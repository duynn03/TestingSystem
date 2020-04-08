package com.vti.testing.form.question;

import javax.validation.constraints.Size;

import com.vti.testing.validation.group.onCreate;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 11, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 11, 2020
 */
public class UserForm {

	private int id;

	@Size(min = 6, max = 50, message = "{UserForm.userName.NotEmpty.Size}", groups = onCreate.class)
	private String name;

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

}
