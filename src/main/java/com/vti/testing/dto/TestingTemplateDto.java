//
package com.vti.testing.dto;

import java.util.Date;
import java.util.List;

import com.vti.testing.entity.Question;
import com.vti.testing.entity.TestingCategory;
import com.vti.testing.entity.enumerate.TestingStatus;

/**
 * This class is testing template dto.
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 17, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 17, 2020
 */
public class TestingTemplateDto {

	private String name;
	private String testingCategory;
	private int version;
	private short time;
	private Date createTime;
	private TestingStatus status = TestingStatus.DRAFT;
	private List<Question> questions;

	

	/**
	 * @return number of questions
	 */
	public int getQuestions() {
		return questions.size();
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
		
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
	public void setTime(short time) {
		this.time = time;

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
	public TestingTemplateDto setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the testingCategory
	 */
	public String getTestingCategory() {
		return testingCategory;
	}

	/**
	 * @param testingCategory the testingCategory to set
	 */
	public void setTestingCategory(TestingCategoryDto testingCategory) {
		this.testingCategory = testingCategory.getName();

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
	public TestingTemplateDto setVersion(int version) {
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
	public void setStatus(TestingStatus status) {
		this.status = status;

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
	public TestingTemplateDto setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

}
