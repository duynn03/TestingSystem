package com.vti.testing.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the answer database table.
 * 
 */
@Entity
@Table(name = "`Answer`")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`", unique = true, nullable = false)
	private int id;

	// bi-directional many-to-one association to Question
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "`question_ID`", nullable = false)
	private Question question;

	@Lob
	@Column(name = "`key`", nullable = false)
	private String key;

	@Column(name = "`is_correct`", nullable = false, columnDefinition = "boolean default false")
	private boolean isCorrect;

	// bi-directional many-to-one association to Image
	@ManyToOne
	@JoinColumn(name = "`Image_ID`")
	private Image image;

	/**
	 * Constructor for class Answer.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
	 */
	public Answer() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public Answer setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public Answer setQuestion(Question question) {
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
	public Answer setKey(String key) {
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
	public Answer setCorrect(boolean isCorrect) {
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
	public Answer setImage(Image image) {
		this.image = image;
		return this;
	}

}