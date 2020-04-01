//
package com.vti.testing.dto.Exam.User;

import java.util.Date;

/**
 * This class is Exam Dto in ROLE MANAGER.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 11, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 11, 2020
 */
public class ExamUserDto {
	private int id;
	private String name;
	private Date startTime;
	private Date endTime;
	private int testingTotal;

	/**
	 * @return the testingTotal
	 */
	public int getTestingTotal() {
		return testingTotal;
	}

	/**
	 * @param testingTotal the testingTotal to set
	 * @return
	 */
	public ExamUserDto setTestingTotal(int testingTotal) {
		this.testingTotal = testingTotal;
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
	 * @return
	 */
	public ExamUserDto setId(int id) {
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
	 * @return
	 */
	public ExamUserDto setName(String name) {
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
	public ExamUserDto setStartTime(Date startTime) {
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
	public ExamUserDto setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	/**
	 * Constructor for class ExamDto.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 11, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 11, 2020
	 */
	public ExamUserDto() {
	}

}