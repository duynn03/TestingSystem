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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.vti.testing.entity.enumerate.GenerationTypeTesting;
import com.vti.testing.entity.enumerate.TestingStatus;

/**
 * The persistent class for the testing database table.
 * 
 */
@Entity
@Table(name = "`Testing`")
public class Testing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`", unique = true, nullable = false)
	private int id;

	@Column(name = "`name`", nullable = false, length = 200)
	private String name;

	// bi-directional many-to-one association to QuestionCategory
	@ManyToOne
	@JoinColumn(name = "`Testing_Category_ID`", nullable = false)
	private TestingCategory testingCategory;

	@Column(name = "`time`", nullable = false)
	private short time;

	@Column(name = "`generation_Type`", nullable = false)
	private GenerationTypeTesting generationType;

	@Column(name = "`version`", nullable = false, columnDefinition = "int default 1")
	private int version;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "`status`", nullable = false)
	private TestingStatus status = TestingStatus.DRAFT;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "`examiner_ID`", nullable = false)
	private User examiner;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "`author_ID`", nullable = false)
	private User author;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "`create_time`", nullable = false)
	@CreationTimestamp
	private Date createTime;

	@Lob
	@Column(name = "`note`")
	private String note;

	// bi-directional many-to-many association to Question
	@ManyToMany(mappedBy = "testings")
	private List<Question> questions;

	// bi-directional many-to-many association to Exam
	@ManyToMany
	@JoinTable(name = "`testing_exam`", joinColumns = {
			@JoinColumn(name = "`testing_id`", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "`exam_id`", nullable = false) })
	private List<Exam> exams;

	/**
	 * Constructor for class Testing.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
	 */
	public Testing() {
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
	public Testing setId(Short id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public Testing setName(String name) {
		this.name = name;
		return this;
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
	public Testing setTestingCategory(TestingCategory testingCategory) {
		this.testingCategory = testingCategory;
		return this;
	}

	/**
	 * @return the time
	 */
	public short getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public Testing setTime(short time) {
		this.time = time;
		return this;
	}

	/**
	 * @return the generationType
	 */
	public GenerationTypeTesting getGenerationType() {
		return generationType;
	}

	/**
	 * @param generationType the generationType to set
	 */
	public Testing setGenerationType(GenerationTypeTesting generationType) {
		this.generationType = generationType;
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
	public Testing setVersion(int version) {
		this.version = version;
		return this;
	}

	/**
	 * @return the status
	 */
	public TestingStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public Testing setStatus(TestingStatus status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the examiner
	 */
	public User getExaminer() {
		return examiner;
	}

	/**
	 * @param examiner the examiner to set
	 */
	public Testing setExaminer(User examiner) {
		this.examiner = examiner;
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
	public Testing setAuthor(User author) {
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
	public Testing setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public Testing setNote(String note) {
		this.note = note;
		return this;
	}

	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public Testing setQuestions(List<Question> questions) {
		this.questions = questions;
		return this;
	}

	/**
	 * @return the exams
	 */
	public List<Exam> getExams() {
		return exams;
	}

	/**
	 * @param exams the exams to set
	 */
	public Testing setExams(List<Exam> exams) {
		this.exams = exams;
		return this;
	}

}