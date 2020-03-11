package com.vti.testing.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
 * The persistent class for the testing_category database table.
 * 
 */
@Entity
@Table(name = "Testing_Category")
public class TestingCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private short id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "author_ID", nullable = false)
	private User author;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false)
	@CreationTimestamp
	private Date createTime;

	// bi-directional many-to-one association to QuestionCategory
	@OneToMany(mappedBy = "testingCategory", cascade = CascadeType.ALL)
	private List<QuestionCategory> questionCategories;

	// bi-directional many-to-one association to TestingCategory
	@OneToMany(mappedBy = "testingCategory")
	private List<Testing> testings;

	/**
	 * Constructor for class TestingCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
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
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public TestingCategory setAuthor(User author) {
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
	public TestingCategory setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	/**
	 * @return the testings
	 */
	public List<Testing> getTestings() {
		return testings;
	}

	/**
	 * @param testings the testings to set
	 */
	public TestingCategory setTestings(List<Testing> testings) {
		this.testings = testings;
		return this;
	}

}