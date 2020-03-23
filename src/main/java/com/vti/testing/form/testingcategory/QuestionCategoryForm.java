package com.vti.testing.form.testingcategory;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.vti.testing.validation.form.questioncategory.QuestionCategoryIDExists;
import com.vti.testing.validation.form.questioncategory.QuestionCategoryNameNotExists;
import com.vti.testing.validation.group.onCreate;
import com.vti.testing.validation.group.onUpdate;

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

	@Null(groups = onCreate.class)
	@NotNull(groups = onUpdate.class)
	@QuestionCategoryIDExists(groups = onUpdate.class)
	private Integer id;

	@NotEmpty(groups = { onCreate.class, onUpdate.class })
	@QuestionCategoryNameNotExists(groups = { onCreate.class, onUpdate.class })
	@Size(max = 50, groups = { onCreate.class, onUpdate.class })
	private String name;

	@NotNull(groups = onCreate.class)
	@Valid
	@Null(groups = onUpdate.class)
	private UserForm author;

	/**
	 * Constructor for class QuestionCategoryForm.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 17, 2020
	 */
	public QuestionCategoryForm() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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

}
