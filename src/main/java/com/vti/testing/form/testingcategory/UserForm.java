package com.vti.testing.form.testingcategory;

import javax.validation.constraints.NotNull;

import com.vti.testing.validation.form.user.UserIDExists;
import com.vti.testing.validation.group.onCreate;

/**
 * This class is user form.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 11, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 11, 2020
 */
public class UserForm {

	@UserIDExists(groups = onCreate.class)
	@NotNull(groups = onCreate.class)
	private Integer id;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
