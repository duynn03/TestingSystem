package com.vti.testing.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the user_group database table.
 * 
 */
@Embeddable
public class UserGroupPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "`group_id`", nullable = false)
	private int groupId;

	@Column(name = "`user_id`", nullable = false)
	private int userId;

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserGroupPK)) {
			return false;
		}
		UserGroupPK castOther = (UserGroupPK) other;
		return (this.groupId == castOther.groupId) && (this.userId == castOther.userId);
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupId;
		hash = hash * prime + this.userId;

		return hash;
	}

	/**
	 * Constructor for class UserGroupPK.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
	 */
	public UserGroupPK() {
	}

	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public UserGroupPK setGroupId(int groupId) {
		this.groupId = groupId;
		return this;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public UserGroupPK setUserId(int userId) {
		this.userId = userId;
		return this;
	}

}