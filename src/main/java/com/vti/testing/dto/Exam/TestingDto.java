//
package com.vti.testing.dto.Exam;

import com.vti.testing.entity.enumerate.TestingStatus;

/**
 * This class is TestingDto.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 18, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 18, 2020
 */
public class TestingDto {

	private String name;
	private short time;
	private int version;
	private TestingStatus status;
	private UserDto examiner;
	private TestingCategoryDto testingCategory;

	/**
	 * @return the testingCategory
	 */
	public TestingCategoryDto getTestingCategory() {
		return testingCategory;
	}

	/**
	 * @param testingCategory the testingCategory to set
	 * @return
	 */
	public TestingDto setTestingCategory(TestingCategoryDto testingCategory) {
		this.testingCategory = testingCategory;
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
	public TestingDto setName(String name) {
		this.name = name;
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
	 * @return
	 */
	public TestingDto setTime(short time) {
		this.time = time;
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
	 * @return
	 */
	public TestingDto setVersion(int version) {
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
	 * @return
	 */
	public TestingDto setStatus(TestingStatus status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the examiner
	 */
	public UserDto getExaminer() {
		return examiner;
	}

	/**
	 * @param examiner the examiner to set
	 * @return
	 */
	public TestingDto setExaminer(UserDto examiner) {
		this.examiner = examiner;
		return this;
	}

}
