//
package com.vti.testing.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import com.vti.testing.entity.Answer;
import com.vti.testing.entity.Image;
import com.vti.testing.entity.QuestionLevel;
import com.vti.testing.entity.enumerate.QuestionStatus;
import com.vti.testing.entity.enumerate.QuestionType;

/**
 * This class is form create question.
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 6, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 6, 2020
 */
public class QuestionForm {

	private Short id;
	
	@NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
	private String title;
	
	@NotBlank
	private QuestionCategoryForm questionCategory;
	
	@NotBlank
	private QuestionType type;
	
	
	private QuestionStatus status;
	
	@NotBlank
	private int version;
	
	@NotBlank
	private UserForm author;
	
	private Date createTime;
	private Image image;
	@NotBlank
	private List<Answer> answer;
	@NotBlank
	private QuestionLevel level;

	/**
	 * @return the image
	 */
	public Short getImage() {
		return image.getId();
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;

	}

	/**
	 * @return the level
	 */
	public QuestionLevel getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(QuestionLevel level) {
		this.level = level;

	}

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public QuestionForm setId(Short id) {
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
	public QuestionForm setTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * @return the questionCategory
	 */
	public QuestionCategoryForm getQuestionCategory() {
		return questionCategory;
	}

	/**
	 * @param questionCategory the questionCategory to set
	 */
	public void setQuestionCategory(QuestionCategoryForm questionCategory) {
		this.questionCategory = questionCategory;

	}

	/**
	 * @return the type
	 */
	public QuestionType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(QuestionType type) {
		this.type = type;

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
	public QuestionForm setVersion(int version) {
		this.version = version;
		return this;
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
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public QuestionForm setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * @return the answer
	 */
	public List<Answer> getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;

	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "View detail question :" + "\nID=" + id + "\nTitle=" + title + "\nQuestionCategory="
				+ questionCategory.getName() + "\nType=" + type + "\nStatus=" + status + "\nVersion=" + version
				+ "\nAuthor=" + author + "\nCreateTime=" + createTime + "\nAnswer=" + answer + "\nLevel=" + level + ".";
	}

}