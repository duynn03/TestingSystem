package com.vti.testing.dto;

import com.vti.testing.entity.QuestionCategory;
import com.vti.testing.entity.QuestionLevel;
import com.vti.testing.entity.User;
import com.vti.testing.entity.enumerate.QuestionStatus;

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
	private String title;
	private QuestionCategory questionCategory;
	private QuestionLevel questionLevel;
	private int version;
	private User author;
	private QuestionStatus status;
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
	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}
	/**
	 * @param questionCategory the questionCategory to set
	 */
	public QuestionDto setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
		return this;
	}
	/**
	 * @return the questionLevel
	 */
	public QuestionLevel getQuestionLevel() {
		return questionLevel;
	}
	/**
	 * @param questionLevel the questionLevel to set
	 */
	public QuestionDto setQuestionLevel(QuestionLevel questionLevel) {
		this.questionLevel = questionLevel;
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
	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public QuestionDto setAuthor(User author) {
		this.author = author;
		return this;
	}
	/**
	 * @return the status
	 */
	public QuestionStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public QuestionDto setStatus(QuestionStatus status) {
		this.status = status;
		return this;
	};

	
	
}
