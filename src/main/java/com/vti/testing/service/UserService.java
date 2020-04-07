package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.vti.testing.entity.RegistrationUserToken;
import com.vti.testing.entity.ResetPasswordToken;
import com.vti.testing.entity.User;
import com.vti.testing.entity.enumerate.UserStatus;

/**
 * This class is User service.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public interface UserService {

	/**
	 * This method uses for getting all Users.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 12, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 12, 2020
	 * @param specification
	 * @param pageable
	 * @return
	 */
	public Page<User> getAllUsers(Specification<User> specification, Pageable pageable);

	/**
	 * This method is used for getting User by id.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param id
	 * @return User
	 */
	public User getUserByID(int id);

	/**
	 * This method is used for getting User by email.
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
	public User getUserByEmail(String email);

	/**
	 * This method uses for creating User .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param entity
	 */
	public User createUser(User entity);

	/**
	 * This method is used for create registration user token for user.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 * @param token
	 */
	public void createRegistrationUserToken(RegistrationUserToken token);

	/**
	 * This method is used for getting user's token.
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
	public RegistrationUserToken getRegistrationUserToken(String token);

	/**
	 * This method is used for checking valid token.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param token
	 * @return
	 */
	public boolean isRegistrationUserTokenValid(String token);

	/**
	 * This method is used for activing user.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param token
	 * @return
	 */
	public void activeUser(String token);

	/**
	 * This method is used for delete registration token of user's id.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param user
	 */
	public void deleteRegistrationUserTokenByUserId(int userId);

	/**
	 * This method is used for create token for user.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 * @param token
	 */
	public void createResetPasswordToken(ResetPasswordToken token);

	/**
	 * This method is used for getting user's token.
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
	public ResetPasswordToken getResetPasswordToken(String token);

	/**
	 * This method is used for delete registration token of user's id.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param user
	 */
	public void deleteResetPasswordTokenByUserId(int userId);

	/**
	 * This method is used for resetting password.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 6, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 6, 2020
	 * @param token
	 * @param newPassword
	 */
	public void resetPassword(String token, String newPassword);

	/**
	 * This method is used for checking valid token.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param token
	 * @return
	 */
	public boolean isResetPasswordTokenValid(String token);

	/**
	 * This method uses for updating User .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param entity
	 */
	public void updateUser(User entity);

	/**
	 * This method uses for deleting User .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param id
	 */
	public void deleteUser(int id);

	/**
	 * This method is checked User exists by id .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param id
	 * @return boolean
	 */
	public boolean existsUser(int id);

	/**
	 * This method is exists By Account.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 26, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 26, 2020
	 * @param account
	 * @return
	 */
	public boolean existsByUserName(String userName);

	/**
	 * This method is exists By Email.
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
	 * This method is checking email is active.
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
	public boolean isEmailActive(String email);
}
