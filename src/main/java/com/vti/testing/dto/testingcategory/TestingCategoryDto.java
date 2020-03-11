package com.vti.testing.dto.testingcategory;

import java.util.Date;
import java.util.List;

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
	private UserDto author;
	private Date createTime;
	private List<QuestionCategoryDto> questionCategories;

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Short id) {
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

	/**
	 * @return the author
	 */
	public UserDto getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(UserDto author) {
		this.author = author;
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
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the questionCategories
	 */
	public List<QuestionCategoryDto> getQuestionCategories() {
		return questionCategories;
	}

	/**
	 * @param questionCategories the questionCategories to set
	 */
	public void setQuestionCategories(List<QuestionCategoryDto> questionCategories) {
		this.questionCategories = questionCategories;
	}
}