package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.testing.entity.Users;

/**
 * This class is UserRepository.
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Mar 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Mar 6, 2020
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Short> {

//	/**
//	 * This method is .
//	 * 
//	 * @Description: .
//	 * @author: NTHung
//	 * @create_date: Mar 6, 2020
//	 * @version: 1.0
//	 * @modifer: NTHung
//	 * @modifer_date: Mar 6, 2020
//	 * @param name
//	 * @return
//	 */
//	public boolean existsByAccount(String account);

	/**
	 * This method is find User By userNAme.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 17, 2020
	 * @param userName
	 * @return
	 */
	Users findByUserName(String userName);
}
