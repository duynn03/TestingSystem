package com.vti.testing.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The persistent class for the user_group database table.
 * 
 */
@Entity
@Table(name = "User_Group")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserGroupPK id;

	// bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name = "group_id", nullable = false, insertable = false, updatable = false)
	private Group group;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "join_time", nullable = false)
	@CreationTimestamp
	private Date joinTime;

	/**
	 * Constructor for class UserGroup.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
	 */
	public UserGroup() {
	}

	/**
	 * @return the id
	 */
	public UserGroupPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public UserGroup setId(UserGroupPK id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public UserGroup setGroup(Group group) {
		this.group = group;
		return this;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public UserGroup setUser(User user) {
		this.user = user;
		return this;
	}

	/**
	 * @return the joinTime
	 */
	public Date getJoinTime() {
		return joinTime;
	}

	/**
	 * @param joinTime the joinTime to set
	 */
	public UserGroup setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
		return this;
	}

}