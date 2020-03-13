package com.vti.testing.dto;

import java.util.Date;
import java.util.List;

import com.vti.testing.entity.Image;
import com.vti.testing.entity.enumerate.QuestionStatus;
import com.vti.testing.entity.enumerate.QuestionType;

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
	private QuestionCategoryDto questionCategory;
	private QuestionType type;
	private QuestionStatus status;
	private int version;
	private UserDto author;
	private Date createTime;
	private Image image;
	private List<AnswerDto> answer;

	/**
	 * @return the id
	 */
	public Short getId() {
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
	public QuestionCategoryDto getQuestionCategory() {
		return questionCategory;
	}

	/**
	 * @param questionCategory the questionCategory to set
	 */
	public QuestionDto setQuestionCategory(QuestionCategoryDto questionCategory) {
		this.questionCategory = questionCategory;
		return this;
	}

	/**
	 * @return the testingCategory
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
	public UserDto getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public QuestionDto setAuthor(UserDto author) {
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
	public QuestionDto setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public QuestionDto setImage(Image image) {
		this.image = image;
		return this;
	}

	/**
	 * @return the answer
	 */
	public List<AnswerDto> getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public QuestionDto setAnswer(List<AnswerDto> answer) {
		this.answer = answer;
		return this;
	}

}
