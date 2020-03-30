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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@Table(name = "`Group`")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`", unique = true, nullable = false)
	private int id;

	@Column(name = "`name`", nullable = false, length = 50)
	private String name;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "`author_ID`", nullable = false)
	private User author;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "`create_time`", nullable = false)
	@CreationTimestamp
	private Date createTime;

	// bi-directional many-to-many association to User
	@ManyToMany(mappedBy = "groups")
	private List<User> users;

	// bi-directional many-to-one association to UserGroup
	@OneToMany(mappedBy = "group")
	private List<UserGroup> userGroups;

	/**
	 * Constructor for class Group.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
	 */
	public Group() {
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
	public Group setId(int id) {
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
	public Group setName(String name) {
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
	public Group setAuthor(User author) {
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
	public Group setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public Group setUsers(List<User> users) {
		this.users = users;
		return this;
	}

	/**
	 * @return the userGroups
	 */
	public List<UserGroup> getUserGroups() {
		return userGroups;
	}

	/**
	 * @param userGroups the userGroups to set
	 */
	public Group setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
		return this;
	}

}