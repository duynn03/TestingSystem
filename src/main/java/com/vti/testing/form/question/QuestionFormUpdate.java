//
package com.vti.testing.form.question;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vti.testing.entity.Question;
import com.vti.testing.entity.QuestionLevel;
import com.vti.testing.entity.enumerate.QuestionStatus;
import com.vti.testing.entity.enumerate.QuestionType;

/**
 * This class is QuestionUpdate.
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Apr 6, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Apr 6, 2020
 */
public class QuestionFormUpdate {

	private int id;
	private TestingCategoryForm testingCategory;

	private QuestionCategoryForm questionCategory;

	private QuestionLevel level;

	private String title;

	private List<AnswerForm> answers;

	private ImageForm image;
	private QuestionStatus status;
	private QuestionType type;
	private int version;

	private UserForm author;

	private Date createTime;
	@Autowired
	QuestionForm questionForm;

	@Autowired
	Question question;

	@Autowired
	ModelMapper modelMaper;

	public QuestionFormUpdate setQuestion(QuestionForm questionForm, Question question) {
		// set testing category
		if (questionForm.getTestingCategory() != null) {
			this.testingCategory = questionForm.getTestingCategory();
		} else {
			this.testingCategory = modelMaper.map(question.getTestings(), TestingCategoryForm.class);
		}

		// set question category
		if (questionForm.getQuestionCategory() != null) {
			this.questionCategory = questionForm.getQuestionCategory();
		} else {
			this.questionCategory = modelMaper.map(question.getQuestionCategory(), QuestionCategoryForm.class);
		}

		// set level
		if (questionForm.getLevel() != null) {
			this.level = questionForm.getLevel();
		} else {
			this.level = question.getQuestionLevel();
		}

		// set title
		if (questionForm.getTitle() != null) {
			this.title = questionForm.getTitle();
		} else {
			this.title = question.getTitle();
		}

		// set answer
		if (questionForm.getAnswers() != null) {
			this.answers = questionForm.getAnswers();
		} else {

			for (int i = 0; i < question.getAnswers().size(); i++) {
				this.answers.add(modelMaper.map(question.getAnswers().get(i), AnswerForm.class));
			}

		}

		// set image
		if (questionForm.getImage() != null) {
			this.image = questionForm.getImage();
		} else {
			this.image = modelMaper.map(question.getImage(), ImageForm.class);
		}

		// set status
		if (questionForm.getStatus() != null) {
			this.status = questionForm.getStatus();
		} else {
			this.status = question.getStatus();
		}

		// set type

		if (questionForm.getType() != null) {
			this.type = questionForm.getType();
		} else {
			this.type = question.getType();
		}

		// set version
		this.version = question.getVersion() + 1;

		// set author
		this.author = modelMaper.map(question.getAuthor(), UserForm.class);

//		// set create time
//		this.createTime = createTime;
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
	public QuestionFormUpdate setId(int id) {
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
	public QuestionFormUpdate setTestingCategory(TestingCategoryForm testingCategory) {
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
	public QuestionFormUpdate setQuestionCategory(QuestionCategoryForm questionCategory) {
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
	public QuestionFormUpdate setLevel(QuestionLevel level) {
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
	public QuestionFormUpdate setTitle(String title) {
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
	public QuestionFormUpdate setAnswers(List<AnswerForm> answers) {
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
	public QuestionFormUpdate setImage(ImageForm image) {
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
	public QuestionFormUpdate setStatus(QuestionStatus status) {
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
	public QuestionFormUpdate setType(QuestionType type) {
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
	public QuestionFormUpdate setVersion(int version) {
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
	public QuestionFormUpdate setAuthor(UserForm author) {
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
	public QuestionFormUpdate setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * @return the questionForm
	 */
	public QuestionForm getQuestionForm() {
		return questionForm;
	}

	/**
	 * @param questionForm the questionForm to set
	 */
	public QuestionFormUpdate setQuestionForm(QuestionForm questionForm) {
		this.questionForm = questionForm;
		return this;
	}

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public QuestionFormUpdate setQuestion(Question question) {
		this.question = question;
		return this;
	}

	/**
	 * @return the modelMaper
	 */
	public ModelMapper getModelMaper() {
		return modelMaper;
	}

	/**
	 * @param modelMaper the modelMaper to set
	 */
	public QuestionFormUpdate setModelMaper(ModelMapper modelMaper) {
		this.modelMaper = modelMaper;
		return this;
	}

}
