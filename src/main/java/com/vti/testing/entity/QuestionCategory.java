package com.vti.testing.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the question_category database table.
 * 
 */
@Entity
@Table(name = "Question_Category")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class QuestionCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "name", nullable = false, length = 50, unique = true)
	private String name;

	// bi-directional many-to-one association to TestingCategory
	@ManyToOne
	@JoinColumn(name = "Testing_Category_ID", nullable = false)
	@JsonIgnore
	private TestingCategory testingCategory;

	/**
	 * Constructor for class QuestionCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Feb 6, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Feb 6, 2020
	 */
	public QuestionCategory() {
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
	public QuestionCategory setId(short id) {
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
	public QuestionCategory setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the testingCategory
	 */
	public TestingCategory getTestingCategory() {
		return testingCategory;
	}

	/**
	 * @param testingCategory the testingCategory to set
	 */
	public QuestionCategory setTestingCategory(TestingCategory testingCategory) {
		this.testingCategory = testingCategory;
		return this;
	}

}