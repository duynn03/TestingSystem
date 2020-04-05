//
package com.vti.testing.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.vti.testing.entity.Testing;

/**
 * This class is .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 17, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 17, 2020
 */
public interface TestingTemplateRepository extends JpaRepositoryImplementation<Testing, Short> {

	/**
	 * 
	 * This method is checked Testing Template exists by name.
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
	public boolean existsByName(String name);
}
