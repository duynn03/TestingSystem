package com.vti.testing.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

import com.vti.testing.entity.enumerate.Gender;
import com.vti.testing.entity.enumerate.UserStatus;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "account", nullable = false, length = 50, unique = true)
	private String account;

	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;

	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@Column(name = "firstName", nullable = false, length = 50)
	private String firstName;

	@Column(name = "lastName", nullable = false, length = 50)
	private String lastName;

	@Formula("concat(firstName, ' ', lastName)")
	private String fullName;

	@Column(name = "gender", nullable = false, length = 1)
	private Gender gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_Of_Birth", nullable = false)
	private Date birthday;

	@Column(name = "address", nullable = false, length = 100)
	private String address;

	@Column(name = "phone", nullable = false, length = 15, unique = true)
	private String phone;

	@Column(name = "role", nullable = false)
	private String role;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status", nullable = false)
	private UserStatus status = UserStatus.ACTIVE;

	// bi-directional many-to-one association to Group
	@OneToMany(mappedBy = "author")
	private List<Group> groupAuthors;

	// bi-directional many-to-one association to UserGroup
	@OneToMany(mappedBy = "user")
	private List<UserGroup> userGroups;

	// bi-directional many-to-many association to Group
	@ManyToMany
	@JoinTable(name = "user_group", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "group_id", nullable = false) })
	private List<Group> groups;

	// bi-directional many-to-one association to TestingCategory
	@OneToMany(mappedBy = "author")
	private List<TestingCategory> testingCategoryAuthors;

	// bi-directional many-to-one association to QuestionCategory
	@OneToMany(mappedBy = "author")
	private List<QuestionCategory> questionCategoryAuthors;

	// bi-directional many-to-one association to Image
	@OneToMany(mappedBy = "author")
	private List<Image> imageAuthors;

	// bi-directional many-to-one association to Question
	@OneToMany(mappedBy = "author")
	private List<Question> questionAuthors;

	// bi-directional many-to-one association to Testing
	@OneToMany(mappedBy = "author")
	private List<Testing> testingAuthors;

	// bi-directional many-to-one association to Testing
	@OneToMany(mappedBy = "examiner")
	private List<Testing> markedTestings;

	// bi-directional many-to-one association to Exam
	@OneToMany(mappedBy = "author")
	private List<Exam> examAuthors;

	/**
	 * Constructor for class User.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 4, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 4, 2020
	 */
	public User() {
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
	public User setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public User setAccount(String account) {
		this.account = account;
		return this;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public User setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public User setGender(Gender gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * @return the date_Of_Birth
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param date_Of_Birth the date_Of_Birth to set
	 */
	public User setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public User setAddress(String address) {
		this.address = address;
		return this;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public User setRole(String role) {
		this.role = role;
		return this;
	}

	/**
	 * @return the status
	 */
	public UserStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public User setStatus(UserStatus status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the groupAuthors
	 */
	public List<Group> getGroupAuthors() {
		return groupAuthors;
	}

	/**
	 * @param groupAuthors the groupAuthors to set
	 */
	public User setGroupAuthors(List<Group> groupAuthors) {
		this.groupAuthors = groupAuthors;
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
	public User setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
		return this;
	}

	/**
	 * @return the groups
	 */
	public List<Group> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public User setGroups(List<Group> groups) {
		this.groups = groups;
		return this;
	}

	/**
	 * @return the testingCategoryAuthors
	 */
	public List<TestingCategory> getTestingCategoryAuthors() {
		return testingCategoryAuthors;
	}

	/**
	 * @param testingCategoryAuthors the testingCategoryAuthors to set
	 */
	public User setTestingCategoryAuthors(List<TestingCategory> testingCategoryAuthors) {
		this.testingCategoryAuthors = testingCategoryAuthors;
		return this;
	}

	/**
	 * @return the questionCategoryAuthors
	 */
	public List<QuestionCategory> getQuestionCategoryAuthors() {
		return questionCategoryAuthors;
	}

	/**
	 * @param questionCategoryAuthors the questionCategoryAuthors to set
	 */
	public User setQuestionCategoryAuthors(List<QuestionCategory> questionCategoryAuthors) {
		this.questionCategoryAuthors = questionCategoryAuthors;
		return this;
	}

	/**
	 * @return the imageAuthors
	 */
	public List<Image> getImageAuthors() {
		return imageAuthors;
	}

	/**
	 * @param imageAuthors the imageAuthors to set
	 */
	public User setImageAuthors(List<Image> imageAuthors) {
		this.imageAuthors = imageAuthors;
		return this;
	}

	/**
	 * @return the questionAuthors
	 */
	public List<Question> getQuestionAuthors() {
		return questionAuthors;
	}

	/**
	 * @param questionAuthors the questionAuthors to set
	 */
	public User setQuestionAuthors(List<Question> questionAuthors) {
		this.questionAuthors = questionAuthors;
		return this;
	}

	/**
	 * @return the testingAuthors
	 */
	public List<Testing> getTestingAuthors() {
		return testingAuthors;
	}

	/**
	 * @param testingAuthors the testingAuthors to set
	 */
	public User setTestingAuthors(List<Testing> testingAuthors) {
		this.testingAuthors = testingAuthors;
		return this;
	}

	/**
	 * @return the markedTestings
	 */
	public List<Testing> getMarkedTestings() {
		return markedTestings;
	}

	/**
	 * @param markedTestings the markedTestings to set
	 */
	public User setMarkedTestings(List<Testing> markedTestings) {
		this.markedTestings = markedTestings;
		return this;
	}

	/**
	 * @return the examAuthors
	 */
	public List<Exam> getExamAuthors() {
		return examAuthors;
	}

	/**
	 * @param examAuthors the examAuthors to set
	 */
	public User setExamAuthors(List<Exam> examAuthors) {
		this.examAuthors = examAuthors;
		return this;
	}

}