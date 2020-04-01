//
package com.vti.testing.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.vti.testing.entity.QuestionLevel;
import com.vti.testing.entity.enumerate.QuestionStatus;
import com.vti.testing.entity.enumerate.QuestionType;
import com.vti.testing.form.testingcategory.QuestionCategoryForm;
import com.vti.testing.form.testingcategory.TestingCategoryForm;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.ApiModelProperty;

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

	private int id;
	private TestingCategoryForm testingCategory;
	private QuestionCategoryForm questionCategory;
	private QuestionLevel level;
	
	@ApiModelProperty(notes = "The Question Title")
	@NotEmpty(message = "{Question.title.NotEmpty}", groups = onCreate.class)
	private String title;
	private List<AnswerForm> answers;
	private ImageForm image;
	private QuestionStatus status;
	private QuestionType type;
	private int version;
	private UserForm author;
	private Date createTime;

	/**
	 * @return the answers
	 */
	public List<AnswerForm> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 * @return 
	 */
	public QuestionForm setAnswers(List<AnswerForm> answers) {
		this.answers = answers;
		return this;
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
	public void setId(Short id) {
		this.id = id;
	}

	/**
	 * @return the testingCategory
	 */
	public TestingCategoryForm getTestingCategory() {
		return testingCategory;
	}

	/**
	 * @param testingCategory the testingCategory to set
	 */
	public void setTestingCategory(TestingCategoryForm testingCategory) {
		this.testingCategory = testingCategory;
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
	 * @return the image
	 */
	public ImageForm getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(ImageForm image) {

		this.image = image;
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
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}