//
package com.vti.testing.dto;

import java.util.Date;
import java.util.List;

import com.vti.testing.entity.Question;
import com.vti.testing.entity.TestingCategory;
import com.vti.testing.entity.enumerate.TestingStatus;

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
public class TestingTemplateDto {

	private String name;
	private TestingCategory testingCategory;
	private int version;
	private TestingStatus status = TestingStatus.DRAFT;
	private List<Question> questions;
	private Date createTime;

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
	public TestingCategory getTestingCategory() {
		return testingCategory;
	}

	/**
	 * @param testingCategory the testingCategory to set
	 */
	public void setTestingCategory(TestingCategory testingCategory) {
		this.testingCategory = testingCategory;

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
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;

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

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		
		return "View detail testing template " + 
				"\nName : " + name + 
				"\nTestingCategory : " + testingCategory.getName()  + 
				"\nVersion : "+ version +
				"\nStatus : " + status + 
				"\nNumber Question: "+ getQuestions().size() +
				"\nCreateTime: " + createTime + "\n";
	}

}
