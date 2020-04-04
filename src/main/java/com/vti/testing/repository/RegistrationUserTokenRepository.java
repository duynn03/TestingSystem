package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.testing.entity.RegistrationUserToken;
import com.vti.testing.entity.User;

/**
 * This class is Token repository.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public interface RegistrationUserTokenRepository extends JpaRepository<RegistrationUserToken, Integer> {

	/**
	 * This method is used for finding token.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 * @param token
	 * @return
	 */
	public RegistrationUserToken findByToken(String token);

	/**
	 * This method is used for finding token by user.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 * @param user
	 * @return
	 */
	public RegistrationUserToken findByUser(User user);

	/**
	 * This method is checked User's Token exists by token
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param token
	 * @return boolean
	 */
	public boolean existsByToken(String token);

}
