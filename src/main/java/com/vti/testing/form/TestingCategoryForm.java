package com.vti.testing.form;

import com.vti.testing.entity.TestingCategory;

/**
 * This class is TestingCategory Form.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public class TestingCategoryForm {

	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public TestingCategoryForm setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * This method convert form to entity in order to create.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 13, 2019
	 * @return entity
	 */
	public TestingCategory toEntityCreate() {
		return new TestingCategory().setName(name);
	}
}
