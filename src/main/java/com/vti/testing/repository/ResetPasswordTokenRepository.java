package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vti.testing.entity.ResetPasswordToken;

/**
 * This class is Reset Password Token repository.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Integer> {

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
	public ResetPasswordToken findByToken(String token);

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

	/**
	 * This method is used for delete token by user.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param user
	 */
	@Transactional
	@Modifying
	@Query("	DELETE 						" 
			+ "	FROM 	ResetPasswordToken 	" 
			+ " WHERE 	user.id = :userId")
	public void deleteByUserId(int userId);

}
