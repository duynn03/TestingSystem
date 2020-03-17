package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.testing.entity.Users;
import com.vti.testing.form.UserForm;

public interface UserService {
	
	 
	/**
	 * This method is page. 
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 5, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 5, 2020
	 * @param pageable
	 * @return
	 */
	public Page<Users> getAllUser(Pageable pageable);

	
	/**
	 * This method is getById. 
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 5, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 5, 2020
	 * @param id
	 * @return
	 */
	public Users getUserByID(short id);

	
	/**
	 * This method is create . 
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 5, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 5, 2020
	 * @param form
	 */
	public void createUser(UserForm form);

	 
	/**
	 * This method is update. 
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 5, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 5, 2020
	 * @param id
	 * @param form
	 */
	public void updateUser(short id, UserForm form);

	
	 
	/**
	 * This method is delete. 
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 5, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 5, 2020
	 * @param id
	 */
	public void deleteUser(short id);

	/**
	 * This method is exists. 
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 5, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 5, 2020
	 * @param id
	 * @return
	 */
	public boolean existsUser(short id);

	/**
	 * This method is exists. 
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 5, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 5, 2020
	 * @param name
	 * @return
	 */
	public boolean existsUser(String name);

}
