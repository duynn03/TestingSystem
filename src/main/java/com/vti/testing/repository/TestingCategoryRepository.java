package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.testing.entity.TestingCategory;

/**
 * This class is Testing Category repository.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public interface TestingCategoryRepository extends JpaRepository<TestingCategory, Short> {

	/**
	 * This method use for getting Testing Category by name.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param id
	 * @return entity
	 */
	public TestingCategory findByName(String name);

	/**
	 * This method is checked Testing Category exists by name
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param name
	 * @return boolean
	 */
	public boolean existsByName(String name);
}
