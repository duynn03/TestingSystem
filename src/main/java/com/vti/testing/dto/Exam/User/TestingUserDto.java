//
package com.vti.testing.dto.Exam.User;


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
public class TestingUserDto {

	private String name;
	private short time;
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
	public TestingUserDto setTestingCategory(TestingCategoryDto testingCategory) {
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
	public TestingUserDto setName(String name) {
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
	public TestingUserDto setTime(short time) {
		this.time = time;
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
	public TestingUserDto setExaminer(UserDto examiner) {
		this.examiner = examiner;
		return this;
	}

}
