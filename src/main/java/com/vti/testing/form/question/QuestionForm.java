//
package com.vti.testing.form.question;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.vti.testing.entity.Question;
import com.vti.testing.entity.QuestionLevel;
import com.vti.testing.entity.enumerate.QuestionStatus;
import com.vti.testing.entity.enumerate.QuestionType;
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

	@ApiModelProperty(notes = "The testing category for question")
	@Valid
	private TestingCategoryForm testingCategory;

	@ApiModelProperty(notes = "The Question Category   for question")
	@NotNull(message = "{QuestionCategoryForm.NotNull}", groups = onCreate.class)
	@Valid
	private QuestionCategoryForm questionCategory;

	@ApiModelProperty(notes = "The Question Level")
	@NotNull(message = "QuestionForm.level.NotNull")
	private QuestionLevel level;

	@ApiModelProperty(notes = "The Question Title")
	@NotEmpty(message = "{Question.title.NotEmpty}", groups = onCreate.class)
	private String title;

	@ApiModelProperty(notes = "The List Answers  of Question")
	private List<AnswerForm> answers;

	private ImageForm image;
	private QuestionStatus status;
	private QuestionType type;
	private int version;

	@ApiModelProperty(notes = "The Question's Author")
	@NotNull(message = "{UserForm.NotNull}", groups = onCreate.class)
	@Valid
	private UserForm author;

	@DateTimeFormat()
	private Date createTime;

	@Autowired
	ModelMapper modelMapper;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public QuestionForm setId(int id) {
		this.id = id;
		return this;
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
	public QuestionForm setTestingCategory(TestingCategoryForm testingCategory) {
		this.testingCategory = testingCategory;
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
	public QuestionForm setQuestionCategory(QuestionCategoryForm questionCategory) {
		this.questionCategory = questionCategory;
		return this;
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
	public QuestionForm setLevel(QuestionLevel level) {
		this.level = level;
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
	 * @return the answers
	 */
	public List<AnswerForm> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public QuestionForm setAnswers(List<AnswerForm> answers) {
		this.answers = answers;
		return this;
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
	public QuestionForm setImage(ImageForm image) {
		this.image = image;
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
	public QuestionForm setStatus(QuestionStatus status) {
		this.status = status;
		return this;
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
	public QuestionForm setType(QuestionType type) {
		this.type = type;
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
	public QuestionForm setAuthor(UserForm author) {
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
	public QuestionForm setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * 
	 * This method is generic seter.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Apr 8, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Apr 8, 2020
	 * @param <T>
	 * @param input
	 */
	public <T> QuestionForm set(T[] input) {

		return this;
	}

	public void updateQuestion(Question entity) {

		// set testing category
		if (testingCategory == null) {
			this.testingCategory = modelMapper.map(entity.getTestings(), TestingCategoryForm.class);
		}

		// set answer
		if (answers == null) {

			for (int i = 0; i < entity.getAnswers().size(); i++) {
				this.answers.add(modelMapper.map(entity.getAnswers().get(i), AnswerForm.class));
			}
		}

		// set image
		if (image == null) {
			this.image = modelMapper.map(entity.getImage(), ImageForm.class);
		}

		// set level
		if (level == null) {
			this.level = entity.getQuestionLevel();
		}

		// set questionCategory
		if (questionCategory == null) {
			this.questionCategory = modelMapper.map(entity.getQuestionCategory(), QuestionCategoryForm.class);
		}

		// set status
		if (status == null) {
			this.status = entity.getStatus();
		}
		// set title
		if (title == null) {
			this.title = entity.getTitle();
		}
		// set type
		if (type == null) {
			this.type = entity.getType();
		}

		// set version
		this.setVersion(entity.getVersion() + 1);
	}
}
