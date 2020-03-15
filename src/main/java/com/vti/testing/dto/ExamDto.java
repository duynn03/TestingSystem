//
package com.vti.testing.dto;

import java.util.Date;

import com.vti.testing.entity.enumerate.ExamStatus;

/**
 * This class is Exam Dto.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 11, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 11, 2020
 */
public class ExamDto {
	private int id;
	private String name;
	private Date startTime;
	private Date endTime;
	private ExamStatus status;
	private UserDto author;
	private int version;
	private Date createTime;
	


	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 * @return
	 */
	public ExamDto setVersion(int version) {
		this.version = version;
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
	 * @return
	 */
	public ExamDto setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

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
	public ExamDto setId(int id) {
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
	public ExamDto setName(String name) {
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
	 * @return
	 */
	public ExamDto setStartTime(Date startTime) {
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
	 * @return
	 */
	public ExamDto setEndTime(Date endTime) {
		this.endTime = endTime;
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
	 * @return
	 */
	public ExamDto setStatus(ExamStatus status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the author
	 */
	public UserDto getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 * @return
	 */
	public ExamDto setAuthor(UserDto author) {
		this.author = author;
		return this;
	}

	/**
	 * Constructor for class ExamDto.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 11, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 11, 2020
	 */
	public ExamDto() {
	}

}
