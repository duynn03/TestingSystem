package com.vti.testing.dto;


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

	private QuestionCategoryDto questionCategory;
	private String title;
	private TestingCategoryDto testingCategory;
	private String questionLevel;
	private int version;
	private UserDto author;
	private QuestionStatus status;

	/**
	 * @return the testingCategory
	 */
	public String getTestingCategory() {
		return testingCategory.getName();
	}

	/**
	 * @param testingCategory the testingCategory to set
	 */
	public void setTestingCategory(TestingCategoryDto testingCategory) {
		this.testingCategory = testingCategory;

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
	public void setTitle(String title) {
		this.title = title;

	}

	/**
	 * @return the questionCategory
	 */
	public String getQuestionCategory() {
		return questionCategory.getName();
	}

	/**
	 * @param questionCategory the questionCategory to set
	 */
	public void setQuestionCategory(QuestionCategoryDto questionCategory) {
		this.questionCategory = questionCategory;

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
	public void setQuestionLevel(String questionLevel) {
		this.questionLevel = questionLevel;

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
	public void setVersion(int version) {
		this.version = version;

	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author.getFullName();
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(UserDto author) {
		this.author = author;

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
	public void setStatus(QuestionStatus status) {
		this.status = status;

	};

}
