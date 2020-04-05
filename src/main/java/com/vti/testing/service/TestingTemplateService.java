//
package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.vti.testing.entity.Testing;

/**
 * This class is interface of Testing template.
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 17, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 17, 2020
 */
public interface TestingTemplateService {

	/**
	 * 
	 * This method is get all Testing Template .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param pageable
	 * @return
	 */
	public Page<Testing> getAllTestingTemplate(Specification<Testing> specification, Pageable pageable);

	/**
	 * 
	 * This method is get all testing template .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param id
	 * @return
	 */
	public Testing getTestingByID(short id);

	/**
	 * 
	 * This method is create testing template.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param entity
	 */
	public void createTesting(Testing entity);

	/**
	 * 
	 * This method is update question.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param entity
	 */
	public void updateTesting(Testing entity);

	/**
	 * 
	 * This method is delete testing template.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param id
	 * @return
	 */
	public boolean deleteTesting(short id);

	/**
	 * 
	 * This method is find testing by id .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param id
	 * @return
	 */
	public boolean existsTestingByID(Short id);

	/**
	 * 
	 * This method  is find testing by name.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Apr 3, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Apr 3, 2020
	 * @param name
	 * @return
	 */
	public boolean existsTestingTemplateByName(String name);
}
