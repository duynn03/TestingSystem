//
package com.vti.testing.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.testing.entity.Image;
import com.vti.testing.entity.Question;
import com.vti.testing.entity.QuestionCategory;
import com.vti.testing.entity.QuestionLevel;
import com.vti.testing.entity.TestingCategory;
import com.vti.testing.entity.User;
import com.vti.testing.entity.enumerate.QuestionStatus;
import com.vti.testing.entity.enumerate.QuestionType;

import javassist.expr.NewArray;

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

	@SuppressWarnings("unused")
	private Short id;

	@NotBlank(message = "Title may not be blank")
	private String title;

	@NotNull(message = "Question_Category_ID may not be null")
	@NotBlank(message = "Question_Category_ID may not be blank")
	private Short Question_Category_ID;

	@SuppressWarnings("unused")
	private QuestionType type;

	@SuppressWarnings("unused")
	private QuestionStatus status;

	@NotNull(message = "level_ID may not be null")
	private Short level_ID;

	private Short version;

	@NotNull(message = "author_ID may not be null")
	private int author_ID;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;

	private short Image_ID;

	public Question toEntityCreate() {
		return new Question().setId(id).setTitle(title)
				.setQuestionCategory(new QuestionCategory()
				.setId(Question_Category_ID))
				.setType(type).setStatus(status)
				.setQuestionLevel(new QuestionLevel()
				.setId(level_ID))
				.setVersion(version)
				.setAuthor(new User()
				.setId(author_ID))
				.setCreateTime(date)
				.setImage(new Image()
				.setId(Image_ID));

	}

	/**
	 * Constructor for class QuestionForm.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 10, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 10, 2020
	 * @param id
	 * @param title
	 * @param question_Category_ID
	 * @param type
	 * @param status
	 * @param level_ID
	 * @param version
	 * @param author_ID
	 * @param date
	 * @param image_ID
	 */
	public QuestionForm(Short id, @NotBlank(message = "Title may not be blank") String title,
			@NotNull(message = "Question_Category_ID may not be null") @NotBlank(message = "Question_Category_ID may not be blank") Short question_Category_ID,
			QuestionType type, QuestionStatus status, @NotNull(message = "level_ID may not be null") Short level_ID,
			Short version, @NotNull(message = "author_ID may not be null") int author_ID, Date date, short image_ID) {
		super();
		this.id = id;
		this.title = title;
		Question_Category_ID = question_Category_ID;
		this.type = type;
		this.status = status;
		this.level_ID = level_ID;
		this.version = version;
		this.author_ID = author_ID;
		this.date = date;
		Image_ID = image_ID;
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
	 * @return the question_Category_ID
	 */
	public Short getQuestion_Category_ID() {
		return Question_Category_ID;
	}

	/**
	 * @param question_Category_ID the question_Category_ID to set
	 */
	public QuestionForm setQuestion_Category_ID(Short question_Category_ID) {
		Question_Category_ID = question_Category_ID;
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
	 * @return the level_ID
	 */
	public Short getLevel_ID() {
		return level_ID;
	}

	/**
	 * @param level_ID the level_ID to set
	 */
	public QuestionForm setLevel_ID(Short level_ID) {
		this.level_ID = level_ID;
		return this;
	}

	/**
	 * @return the version
	 */
	public Short getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public QuestionForm setVersion(Short version) {
		this.version = version;
		return this;
	}

	/**
	 * @return the author_ID
	 */
	public int getAuthor_ID() {
		return author_ID;
	}

	/**
	 * @param author_ID the author_ID to set
	 */
	public QuestionForm setAuthor_ID(int author_ID) {
		this.author_ID = author_ID;
		return this;
	}

	/**
	 * @param image_ID the image_ID to set
	 */
	public QuestionForm setImage_ID(short image_ID) {
		Image_ID = image_ID;
		return this;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public QuestionForm setDate(Date date) {
		this.date = date;
		return this;
	}

	/**
	 * @return the image_ID
	 */
	public Short getImage_ID() {
		return Image_ID;
	}

	/**
	 * @param image_ID the image_ID to set
	 */
	public QuestionForm setImage_ID(Short image_ID) {
		Image_ID = image_ID;
		return this;
	}

}