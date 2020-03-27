//
package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.testing.entity.Group;

/**
 * This class is group service
 * 
 * @Description: .
 * @author: NATOAN
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NAToan
 * @modifer_date: Mar 12, 2020
 */
public interface GroupService {
	/**
	 * This method uses for getting all Group.
	 * 
	 * @Description: .
	 * @author: NAToan
	 * @create_date: Mar 12, 2020
	 * @version: 1.0
	 * @modifer: NAToan
	 * @modifer_date: Mar 12, 2020
	 * @param pageable
	 * @return
	 */
	public Page<Group> getAllGroup(Pageable pageable);

	/**
	 * 
	 * This method is checked Group exists by id
	 * 
	 * @Description: .
	 * @author: NAToan
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: NAToan
	 * @modifer_date: Mar 25, 2020
	 * @param id
	 * @return
	 */
	public boolean existsGroup(int id);

	/**
	 * 
	 * This method is checked Group exists by name
	 * 
	 * @Description: .
	 * @author: NAToan
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: NAToan
	 * @modifer_date: Mar 25, 2020
	 * @param name
	 * @return
	 */
	public boolean existsGroup(String name);

}
