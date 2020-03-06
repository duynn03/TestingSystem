package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.testing.entity.User;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Mar 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Mar 6, 2020
 */
public interface UserRepository extends JpaRepository<User, Short> {

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 6, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 6, 2020
	 * @param name
	 * @return
	 */
	public boolean existsByAccount(String account);
}
