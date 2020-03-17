//
package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.testing.entity.Question;
import com.vti.testing.entity.TestingCategory;

/**
 * This class is .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 5, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 5, 2020
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Short> {

	/**
	 * 
	 * This method use for getting Question by name .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 15, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 15, 2020
	 * @param name
	 * @return
	 */
	//public Question findByName(String name);

	/**
	 * 
	 * This method is checked Testing Category exists by name.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 15, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 15, 2020
	 * @param name
	 * @return
	 */
	// boolean existsByName(String name);
}
