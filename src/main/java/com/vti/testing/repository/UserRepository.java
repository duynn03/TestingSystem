package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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
	 * This method is .
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
<<<<<<< HEAD
	 * This method is exists By Email.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 30, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 30, 2020
	 * @param email
	 * @return
	 */
	public boolean existsByEmail(String email);

	/**
	 * This method is exists By ID and Status = Block.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Apr 1, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Apr 1, 2020
	 * @param id
	 * @param status
	 * @return
	 */
	public boolean existsByIdAndStatus(int id, UserStatus status);
=======
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
>>>>>>> develop
}
