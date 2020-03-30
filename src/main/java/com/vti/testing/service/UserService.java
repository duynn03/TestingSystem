package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.vti.testing.entity.User;

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
	 * This method uses for getting User by id.
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
	public void createUser(User entity);

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
}
