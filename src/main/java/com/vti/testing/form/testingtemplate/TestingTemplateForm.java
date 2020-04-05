//
package com.vti.testing.form.testingtemplate;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.vti.testing.entity.Exam;
import com.vti.testing.entity.Question;
import com.vti.testing.entity.TestingCategory;
import com.vti.testing.entity.User;
import com.vti.testing.entity.enumerate.GenerationTypeTesting;
import com.vti.testing.entity.enumerate.TestingStatus;
import com.vti.testing.validation.form.Exam.ExamNamenotExists;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.ApiModelProperty;

/**
 * This class is .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 17, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 17, 2020
 */
public class TestingTemplateForm {
	private Short id;

	@NotBlank(message = "TestingTemplateForm.name.NotBlank")
	@Length(max = 50, message = "TestingTemplateForm.name.Length")
	private String name;

	@Size(max = 50, message = "{QuestionCategoryForm.name.Size}")
	private TestingCategory testingCategory;

	@NotNull(message = "TestingTemplateForm.time.NotNull")
	@DateTimeFormat
	private short time;

	@ApiModelProperty(notes = "The Generation Type Testing (RANDOM or Custom)")
	@NotNull(message = "TestingTemplateForm.GenerationTypeTesting.NotNull")
	private GenerationTypeTesting generationType;

	private int version;
	private TestingStatus status = TestingStatus.DRAFT;
	private User examiner;
	private User author;
	private Date createTime;
	private String note;
	private List<Question> questions;
	private List<Exam> exams;

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public TestingTemplateForm setId(Short id) {
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
	public TestingTemplateForm setName(String name) {
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
	public TestingTemplateForm setTestingCategory(TestingCategory testingCategory) {
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
	public TestingTemplateForm setTime(short time) {
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
	public TestingTemplateForm setGenerationType(GenerationTypeTesting generationType) {
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
	public TestingTemplateForm setVersion(int version) {
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
	public TestingTemplateForm setStatus(TestingStatus status) {
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
	public TestingTemplateForm setExaminer(User examiner) {
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
	public TestingTemplateForm setAuthor(User author) {
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
	public TestingTemplateForm setCreateTime(Date createTime) {
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
	public TestingTemplateForm setNote(String note) {
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
	public TestingTemplateForm setQuestions(List<Question> questions) {
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
	public TestingTemplateForm setExams(List<Exam> exams) {
		this.exams = exams;
		return this;
	}

}
