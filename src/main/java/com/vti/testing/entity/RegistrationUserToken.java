package com.vti.testing.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class is Registration User Token.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Apr 2, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Apr 2, 2020
 */
@Entity
@Table(name = "`RegistrationUserToken`")
public class RegistrationUserToken implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final long EXPIRATION_TIME = 86400000l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`", unique = true, nullable = false)
	private int id;

	@Column(name = "`token`", nullable = false, length = 36, unique = true)
	private String token;

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "`expiryDate`", nullable = false)
	private Date expiryDate;

	/**
	 * This method is getted default Expiry Date.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 3, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 3, 2020
	 * @return
	 */
	private Date getDefaultExpiryDate() {
		return new Date(System.currentTimeMillis() + EXPIRATION_TIME);
	}

	/**
	 * This method is used for checking expiry date.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 * @return
	 */
	public boolean isExpiryDate() {
		return expiryDate.getTime() < System.currentTimeMillis();
	}

	/**
	 * Constructor for class VerificationToken.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 */
	public RegistrationUserToken() {
		expiryDate = getDefaultExpiryDate();

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
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public RegistrationUserToken setToken(String token) {
		this.token = token;
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
	public RegistrationUserToken setUser(User user) {
		this.user = user;
		return this;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public RegistrationUserToken setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
		return this;
	}

}
