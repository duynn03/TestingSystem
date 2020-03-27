package com.vti.testing.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The persistent class for the question_category database table.
 * 
 */
@Entity
@Table(name = "`Question_Category`")
public class QuestionCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`", unique = true, nullable = false, updatable = false)
	private short id;

	@Column(name = "`name`", nullable = false, length = 50)
	private String name;

	// bi-directional many-to-one association to TestingCategory
	@ManyToOne
	@JoinColumn(name = "`Testing_Category_ID`", nullable = false, updatable = false)
	private TestingCategory testingCategory;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "`author_ID`", nullable = false, updatable = false)
	private User author;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "`create_time`", nullable = false, updatable = false)
	@CreationTimestamp
	private Date createTime;

	// bi-directional many-to-one association to Question
	@OneToMany(mappedBy = "questionCategory")
	private List<Question> questions;

	/**
	 * Constructor for class QuestionCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
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

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public QuestionCategory setAuthor(User author) {
		this.author = author;
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
	public QuestionCategory setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public QuestionCategory setQuestions(List<Question> questions) {
		this.questions = questions;
		return this;
	}

}