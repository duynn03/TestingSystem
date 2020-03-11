package com.vti.testing.form;

import java.util.Date;

/**
 * This class is question category form.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 11, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 11, 2020
 */
public class QuestionCategoryForm {

	private int id;
	private String name;
	private UserForm author;
	private Date createTime;

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
	public UserForm getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(UserForm author) {
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

}
