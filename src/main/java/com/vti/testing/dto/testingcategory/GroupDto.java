//
package com.vti.testing.dto.testingcategory;

import java.util.Date;
import java.util.List;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NATOAN
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NAToan
 * @modifer_date: Mar 12, 2020
 */
public class GroupDto {
	private int id;
	private String name;
	private AuthorDto author;
	private Date createTime;
	private List<AuthorDto> users;
	
	/**
	 * @return the users
	 */
	public List<AuthorDto> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 * @return 
	 */
	public GroupDto setUsers(List<AuthorDto> users) {
		this.users = users;
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
	 */
	public GroupDto setId(int id) {
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
	public GroupDto setName(String name) {
		this.name = name;
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
	public GroupDto setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	/**
	 * @return the author
	 */
	public AuthorDto getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public GroupDto setAuthor(AuthorDto author) {
		this.author = author;
		return this;
	}
	

}
