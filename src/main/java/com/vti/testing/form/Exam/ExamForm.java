
package com.vti.testing.form.Exam;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.vti.testing.validation.form.Exam.ExamNamenotExists;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.ApiModel;

/**
 * This class is Exam Form.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 11, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 11, 2020
 */
@ApiModel(value = "This is form when creating or updating Exam")
public class ExamForm {

	@NotBlank(message = "ExamForm.name.NotBlank")
	@Length(max = 50, message = "ExamForm.name.Length")
	@ExamNamenotExists(groups = onCreate.class)
	private String name;

	@NotNull(message = "ExamForm.startTime.NotNull")
	@DateTimeFormat
	private Date startTime;

	@NotNull(message = "ExamForm.endTime.NotNull")
	@DateTimeFormat
	private Date endTime;

	private UserForm author;

	private List<TestingForm> testings;

	private int version = 1;

	/**
	 * @return the testings
	 */

	/**
	 * @return the testings
	 */
	public List<TestingForm> getTestings() {
		return testings;
	}

	/**
	 * @param testings the testings to set
	 * @return
	 */
	public ExamForm setTestings(List<TestingForm> testings) {
		this.testings = testings;
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
	 * @return
	 */
	public ExamForm setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 * @return
	 */
	public ExamForm setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 * @return
	 */
	public ExamForm setEndTime(Date endTime) {
		this.endTime = endTime;
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
	 * @return
	 */
	public ExamForm setAuthor(UserForm author) {
		this.author = author;
		return this;
	}

	/**
	 * Constructor for class ExamForm.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 11, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 11, 2020
	 */
	public ExamForm() {
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 * @return
	 */
	public ExamForm setVersion(int version) {
		this.version = version;
		return this;
	}

}
