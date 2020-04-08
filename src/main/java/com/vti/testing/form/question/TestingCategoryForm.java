//
package com.vti.testing.form.question;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.vti.testing.validation.form.testingcategory.TestingCategoryNameNotExists;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.ApiModelProperty;

/**
 * This class is TestingCategoryForm for createQuestion and updateQuestion .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Apr 6, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Apr 6, 2020
 */
public class TestingCategoryForm {

	private short id;
	
	@Size(max = 50, message = "{TestingCategoryForm.name.Size}", groups = onCreate.class)
	private String name;

	/**
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(short id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
