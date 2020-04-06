package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.vti.testing.entity.User;
import com.vti.testing.entity.enumerate.UserStatus;

/**
 * This class is User repository.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	/**
	 * This method is checking exists user by user name.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 27, 2020
	 * @param account
	 * @return
	 */
	public boolean existsByUserName(String userName);

	/**
	 * This method is checking exists user by email.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param email
	 * @return
	 */
	public boolean existsByEmail(String email);
	
	/**
	 * This method is used for finding user's status by email. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param email
	 * @return
	 */
	@Query("	SELECT 	status 		"
			+ "	FROM 	User 		"
			+ " WHERE 	email = :email")
	public UserStatus findStatusByEmail(String email);

	/**
	 * This method is find User by userName.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Apr 1, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Apr 1, 2020
	 * @param name
	 * @return
	 */
	public User findByUserName(String name);
	
	/**
	 * This method is find User by email.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Apr 1, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Apr 1, 2020
	 * @param name
	 * @return
	 */
	public User findByEmail(String email);
}
