package com.vti.testing.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

/**
 * The persistent class for the question_level database table.
 * 
 */
@Entity
@Table(name = "Question_Level")
public class QuestionLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private short id;

	@Column(name = "level", nullable = false, length = 20)
	private String level;

	// bi-directional many-to-one association to Question
	@OneToMany(mappedBy = "questionLevel")
	private List<Question> questions;

	/**
	 * Constructor for class QuestionLevel.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
	 */
	public QuestionLevel() {
	}

	/**
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public QuestionLevel setId(short id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public QuestionLevel setLevel(String level) {
		this.level = level;
		return this;
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
	public QuestionLevel setQuestions(List<Question> questions) {
		this.questions = questions;
		return this;
	}

}