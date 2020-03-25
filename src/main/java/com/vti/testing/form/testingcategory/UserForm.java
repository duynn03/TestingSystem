package com.vti.testing.form.testingcategory;

import javax.validation.constraints.NotNull;

import com.vti.testing.validation.form.user.UserIDExists;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel(description = "This is User form when creating or updating Testing Category")
public class UserForm {

	@ApiModelProperty(notes = "The Author's ID")
	@UserIDExists(groups = onCreate.class)
	@NotNull(message = "{UserForm.id.NotNull}", groups = onCreate.class)
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
