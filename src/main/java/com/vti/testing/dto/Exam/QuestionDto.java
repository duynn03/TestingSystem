//
package com.vti.testing.dto.Exam;

import com.vti.testing.entity.enumerate.QuestionType;

/**
 * This class is QuestionDto.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 18, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 18, 2020
 */
public class QuestionDto {

	private String title;
	private QuestionType type;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 * @return
	 */
	public QuestionDto setTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * @return the type
	 */
	public QuestionType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 * @return
	 */
	public QuestionDto setType(QuestionType type) {
		this.type = type;
		return this;
	}

}
