package com.vti.testing.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the testing_category database table.
 * 
 */
@Entity
@Table(name = "Testing_Category")
public class TestingCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "name", nullable = false, length = 50, unique = true)
	@NotNull
	private String name;

	// bi-directional many-to-one association to QuestionCategory
	@OneToMany(mappedBy = "testingCategory")
	private List<QuestionCategory> questionCategories;

	/**
	 * Constructor for class TestingCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Feb 6, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Feb 6, 2020
	 */
	public TestingCategory() {
	}

	/**
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public TestingCategory setId(short id) {
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
	public TestingCategory setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the questionCategories
	 */
	public List<QuestionCategory> getQuestionCategories() {
		return questionCategories;
	}

	/**
	 * @param questionCategories the questionCategories to set
	 */
	public TestingCategory setQuestionCategories(List<QuestionCategory> questionCategories) {
		this.questionCategories = questionCategories;
		return this;
	}

}