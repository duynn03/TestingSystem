//
package com.vti.testing.form;

import com.vti.testing.entity.enumerate.GenerationTypeTesting;

/**
 * This class is Form Testing .
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 12, 2020
 */
public class TestingForm {

	private int id;
	private String name;
	private TestingCategoryForm testingCategory;
	private short time;
	private GenerationTypeTesting generationType;
	private String note;

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
	public TestingForm setId(int id) {
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
	public TestingForm setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the testingCategory
	 */
	public TestingCategoryForm getTestingCategory() {
		return testingCategory;
	}

	/**
	 * @param testingCategory the testingCategory to set
	 * @return
	 */
	public TestingForm setTestingCategory(TestingCategoryForm testingCategory) {
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
	 * @return
	 */
	public TestingForm setTime(short time) {
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
	 * @return
	 */
	public TestingForm setGenerationType(GenerationTypeTesting generationType) {
		this.generationType = generationType;
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
	 * @return
	 */
	public TestingForm setNote(String note) {
		this.note = note;
		return this;
	}

}
