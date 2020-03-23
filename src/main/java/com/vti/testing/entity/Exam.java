package com.vti.testing.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.vti.testing.entity.enumerate.ExamStatus;

/**
 * The persistent class for the exam database table.
 * 
 */
@Entity
@Table(name = "Exam")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time", nullable = false)
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time", nullable = false)
	private Date endTime;

	@Column(name = "version", nullable = false, columnDefinition = "int default 1")
	private int version;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status", nullable = false)
	private ExamStatus status = ExamStatus.DRAFT;

	// bi-directional many-to-one association to User
	@ManyToOne(cascade = CascadeType.MERGE)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JoinColumn(name = "author_ID")
	private User author;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false)
	@CreationTimestamp
	private Date createTime;

	@Lob
	@Column(name = "note")
	private String note;

	// bi-directional many-to-many association to Testing
	@ManyToMany(mappedBy = "exams", cascade = CascadeType.MERGE)
	private List<Testing> testings;

	/**
	 * Constructor for class Exam.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Mar 4, 2020
	 */
	public Exam() {
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
	public Exam setId(int id) {
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
	public Exam setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public Exam setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public Exam setEndTime(Date endTime) {
		this.endTime = endTime;
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
	 */
	public Exam setVersion(int version) {
		this.version = version;
		return this;
	}

	/**
	 * @return the status
	 */
	public ExamStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public Exam setStatus(ExamStatus status) {
		this.status = status;
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
	public Exam setAuthor(User author) {
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
	public Exam setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	 */
	public Exam setNote(String note) {
		this.note = note;
		return this;
	}

	/**
	 * @return the testings
	 */
	public List<Testing> getTestings() {
		return testings;
	}

	/**
	 * @param testings the testings to set
	 */
	public Exam setTestings(List<Testing> testings) {
		this.testings = testings;
		return this;
	}

}