package com.vti.testing.form.testingcategory;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vti.testing.validation.form.testingcategory.TestingCategoryNameNotExists;
import com.vti.testing.validation.group.onCreate;

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
	private short id;
	@NotEmpty(groups = onCreate.class)
	@Size(max = 50, groups = onCreate.class)
	@TestingCategoryNameNotExists(groups = onCreate.class)
	private String name;

	@NotNull(groups = onCreate.class)
	@Valid
	private UserForm author;

	private List<@Valid QuestionCategoryForm> questionCategories;

	/**
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 * @return
	 */
	public TestingCategoryForm setId(short id) {
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
