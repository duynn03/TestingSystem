package com.vti.testing.form;

import java.util.List;

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
	private UserForm author;
	private List<QuestionCategoryForm> questionCategories;

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
	 * @return the questionCategories
	 */
	public List<QuestionCategoryForm> getQuestionCategories() {
		return questionCategories;
	}

	/**
	 * @param questionCategories the questionCategories to set
	 */
	public void setQuestionCategories(List<QuestionCategoryForm> questionCategories) {
		this.questionCategories = questionCategories;
	}

}
