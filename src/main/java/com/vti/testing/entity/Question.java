package com.vti.testing.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.vti.testing.entity.enumerate.QuestionStatus;
import com.vti.testing.entity.enumerate.QuestionType;

/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@Table(name = "Question")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Lob
	@Column(name = "title", nullable = false)
	private String title;

	// bi-directional many-to-one association to QuestionCategory
	@ManyToOne
	@JoinColumn(name = "Question_Category_ID", nullable = false)
	private QuestionCategory questionCategory;

	@Column(name = "type", nullable = false)
	private QuestionType type;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status", nullable = false)
	private QuestionStatus status = QuestionStatus.DRAFT;

	// bi-directional many-to-one association to QuestionLevel
	@ManyToOne
	@JoinColumn(name = "level_ID", nullable = false)
	private QuestionLevel questionLevel;

	@Column(name = "version", nullable = false, columnDefinition = "int default 1")
	private int version;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "author_ID", nullable = false)
	private User author;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false)
	@CreationTimestamp
	private Date createTime;

	// bi-directional many-to-one association to Image
	@ManyToOne
	@JoinColumn(name = "Image_ID")
	private Image image;

	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	// bi-directional many-to-many association to Testing
	@ManyToMany
	@JoinTable(name = "question_testing", joinColumns = {
			@JoinColumn(name = "question_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "testing_id", nullable = false) })
	private List<Testing> testings;

	/**
	 * Constructor for class Question.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
	 */
	public Question() {
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
	public Question setId(int id) {
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
	public Question setTitle(String title) {
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
	public Question setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
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
	public Question setType(QuestionType type) {
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
	public Question setStatus(QuestionStatus status) {
		this.status = status;
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
	public Question setQuestionLevel(QuestionLevel questionLevel) {
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
	public Question setVersion(int version) {
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
	public Question setAuthor(User author) {
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
	public Question setCreateTime(Date createTime) {
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
	public Question setImage(Image image) {
		this.image = image;
		return this;
	}

	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public Question setAnswers(List<Answer> answers) {
		this.answers = answers;
		return this;
	}

	/**
	 * @return the testings
	 */
	public List<Testing> getTestings() {
		return testings;
	}

	/**
	 * @param testings the testings to set
	 */
	public Question setTestings(List<Testing> testings) {
		this.testings = testings;
		return this;
	}

}