package com.vti.testing.dto;

import com.vti.testing.entity.TestingCategory;

/**
 * This class is TestingCategory dto.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public class TestingCategoryDto {

	private Short id;
	private String name;

	/**
	 * Constructor for class TestingCategoryDto.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * 
	 */
	public TestingCategoryDto(TestingCategory entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
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
