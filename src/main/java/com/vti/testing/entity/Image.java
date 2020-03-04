package com.vti.testing.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@Table(name = "Image")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private short id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "author_ID", nullable = false)
	private User author;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false)
	@CreationTimestamp
	private Date createTime;

	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "image")
	private List<Answer> answers;

	// bi-directional many-to-one association to Question
	@OneToMany(mappedBy = "image")
	private List<Question> questions;

	/**
	 * Constructor for class Image.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
	 */
	public Image() {
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
	public Image setId(short id) {
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
	 */
	public Image setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public Image setAuthor(User author) {
		this.author = author;
		return this;
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
	public Image setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public Image setAnswers(List<Answer> answers) {
		this.answers = answers;
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
	public Image setQuestions(List<Question> questions) {
		this.questions = questions;
		return this;
	}

}