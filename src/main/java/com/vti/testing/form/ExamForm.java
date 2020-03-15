//
package com.vti.testing.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.vti.testing.entity.enumerate.ExamStatus;
import com.vti.testing.util.Constants;

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
public class ExamForm {

	@NotBlank
	@Length(max = 50)
	private String name;
	@DateTimeFormat
	private Date startTime;
	@DateTimeFormat
	private Date endTime;
	@NotBlank
	private UserForm author;
//	private List<TestingForm> testings;
	private static int version = Constants.VERSION_STATUS;
	private static ExamStatus status = Constants.EXAM_DRAFT_STATUS;;
	/**
	 * @return the testings
	 */
//	public List<TestingForm> getTestings() {
//		return testings;
//	}
//
//	/**
//	 * @param testings the testings to set
//	 * @return
//	 */
//	public ExamForm setTestings(List<TestingForm> testings) {
//		this.testings = testings;
//		return this;
//	}

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
		return this;
	}

	/**
	 * @return the status
	 */
	public ExamStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 * @return
	 */
	public ExamForm setStatus(ExamStatus status) {
		return this;
	}

}
