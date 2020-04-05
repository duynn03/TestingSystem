//
package com.vti.testing.dto;

import com.vti.testing.dto.question.QuestionDto;
import com.vti.testing.entity.Image;

/**
 * This class is .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 13, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 13, 2020
 */
public class AnswerDto {
	private int id;
	private QuestionDto question;
	private String key;
	private boolean isCorrect;
	private Image image;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public AnswerDto setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the question
	 */
	public QuestionDto getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public AnswerDto setQuestion(QuestionDto question) {
		this.question = question;
		return this;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public AnswerDto setKey(String key) {
		this.key = key;
		return this;
	}

	/**
	 * @return the isCorrect
	 */
	public boolean isCorrect() {
		return isCorrect;
	}

	/**
	 * @param isCorrect the isCorrect to set
	 */
	public AnswerDto setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
		return this;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public AnswerDto setImage(Image image) {
		this.image = image;
		return this;
	}

}
