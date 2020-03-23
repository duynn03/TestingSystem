//
package com.vti.testing.form;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.vti.testing.entity.Answer;
import com.vti.testing.entity.Image;
import com.vti.testing.entity.QuestionCategory;
import com.vti.testing.entity.QuestionLevel;
import com.vti.testing.entity.TestingCategory;
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
	private TestingCategory testingCategory;
	private QuestionCategory questionCategory;
	private QuestionLevel level;
	private String title;
	private List<Answer> answer;
	private Image image;
	private QuestionStatus status;
	private QuestionType type;
	private int version;
	private UserForm author;
	private Date createTime;

	/**
	 * @return the id
	 */
	public Short getId() {
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
	public TestingCategory getTestingCategory() {
		return testingCategory;
	}

	/**
	 * @param testingCategory the testingCategory to set
	 */
	public void setTestingCategory(TestingCategory testingCategory) {
		this.testingCategory = testingCategory;
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
	public void setQuestionCategory(QuestionCategory questionCategory) {
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

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		
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