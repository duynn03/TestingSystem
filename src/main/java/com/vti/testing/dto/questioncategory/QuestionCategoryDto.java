package com.vti.testing.dto.questioncategory;

import java.util.Date;

import com.vti.testing.entity.TestingCategory;

/**
 * This class is QuestionCategoryDto.
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Apr 7, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Apr 7, 2020
 */
public class QuestionCategoryDto {

	private int id;
	private String name;
	private TestingCategoryId testingCategoryId;
	private Date createTime;
	private UserDto author;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public QuestionCategoryDto setId(int id) {
		this.id = id;
		return this;
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
	public QuestionCategoryDto setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public QuestionCategoryDto setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * @return the author
	 */
	public UserDto getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public QuestionCategoryDto setAuthor(UserDto author) {
		this.author = author;
		return this;
	}

	/**
	 * @return the testingCategoryId
	 */
	public TestingCategoryId getTestingCategoryId() {
		return testingCategoryId;
	}

	/**
	 * @param testingCategoryId the testingCategoryId to set
	 */
	public QuestionCategoryDto setTestingCategoryId(TestingCategoryId testingCategoryId) {
		this.testingCategoryId = testingCategoryId;
		return this;
	}

}
