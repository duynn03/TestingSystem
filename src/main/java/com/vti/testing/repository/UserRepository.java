package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.testing.entity.User;

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
}
