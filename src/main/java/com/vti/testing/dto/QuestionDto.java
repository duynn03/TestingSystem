package com.vti.testing.dto;

import com.vti.testing.entity.Question;
import com.vti.testing.entity.TestingCategory;

/**
 * 
 * This class is covert from font end to entity & entity -> front end.
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 5, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 5, 2020
 */
public class QuestionDto {
	private Short id;
	private String title;
	private String questionCategory;
	private String testingCategory;
	private String questionLevel;
	private String author;
	private String status;
	private int version;



	/**
	 * Constructor for class QuestionDto.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 6, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 6, 2020
	 * @param question
	 */
	public QuestionDto(Question question) {
		this.id = question.getId();
		this.author = question.getAuthor().getFirstName() + " " + question.getAuthor().getLastName();
		this.title = question.getTitle();
		this.questionCategory = question.getQuestionCategory().getName();
		//this.testingCategory = testingCategory.getName();
		this.questionLevel = question.getQuestionLevel().getLevel();
		this.status = question.getStatus().name();
		this.version = question.getVersion();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public QuestionDto setId(Short id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public QuestionDto setTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * @return the questionCategory
	 */
	public String getQuestionCategory() {
		return questionCategory;
	}

	/**
	 * @param questionCategory the questionCategory to set
	 */
	public QuestionDto setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
		return this;
	}

	/**
	 * @return the testingCategory
	 */
	public String getTestingCategory() {
		return testingCategory;
	}

	/**
	 * @param testingCategory the testingCategory to set
	 */
	public QuestionDto setTestingCategory(String testingCategory) {
		this.testingCategory = testingCategory;
		return this;
	}

	/**
	 * @return the questionLevel
	 */
	public String getQuestionLevel() {
		return questionLevel;
	}

	/**
	 * @param questionLevel the questionLevel to set
	 */
	public QuestionDto setQuestionLevel(String questionLevel) {
		this.questionLevel = questionLevel;
		return this;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public QuestionDto setAuthor(String author) {
		this.author = author;
		return this;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public QuestionDto setStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public QuestionDto setVersion(int version) {
		this.version = version;
		return this;
	}

}
