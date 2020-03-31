//
package com.vti.testing.dto.group;

import java.util.Date;
import java.util.List;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NATOAN
 * @create_date: Mar 27, 2020
 * @version: 1.0
 * @modifer: NAToan
 * @modifer_date: Mar 27, 2020
 */
public class GroupDto {
	private int id;
	private String name;
	private UserDto author;
	private Date createTime;
	private int memberTotal;
	private List<UserDto> users;

	/**
	 * @return the users
	 */
	public List<UserDto> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public GroupDto setUsers(List<UserDto> users) {
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
	public UserDto getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public GroupDto setAuthor(UserDto author) {
		this.author = author;
		return this;
	}

	/**
	 * @return the memberTotal
	 */
	public int getMemberTotal() {
		return memberTotal;
	}

	/**
	 * @param memberTotal the memberTotal to set
	 */
	public void setMemberTotal(int memberTotal) {
		this.memberTotal = memberTotal;
	}

}
