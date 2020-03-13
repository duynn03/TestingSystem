package com.vti.testing.dto;

import java.util.Date;

/**
 * This class is QuestionCategoryDto.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 10, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 10, 2020
 */
public class QuestionCategoryDto {

	private int id;
	private String name;
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

}
