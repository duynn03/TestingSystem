package com.vti.testing.form.testingcategory;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vti.testing.validation.form.testingcategory.TestingCategoryNameNotExists;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel(description = "This is form when creating or updating Testing Category")
public class TestingCategoryForm {

	private short id;
	@ApiModelProperty(notes = "The Testing Category's Name")
	@NotEmpty(message = "{TestingCategoryForm.name.NotEmpty}", groups = onCreate.class)
	@Size(max = 50, message = "{TestingCategoryForm.name.Size}", groups = onCreate.class)
	@TestingCategoryNameNotExists(groups = onCreate.class)
	private String name;

	@ApiModelProperty(notes = "The Testing Category's Author")
	@NotNull(message = "{UserForm.NotNull}", groups = onCreate.class)
	@Valid
	private UserForm author;

	@ApiModelProperty(notes = "The List Question Categories of Testing Category")
	private List<@Valid QuestionCategoryForm> questionCategories;

	/**
	 * @return the id
	 */
	public Short getId() {
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
