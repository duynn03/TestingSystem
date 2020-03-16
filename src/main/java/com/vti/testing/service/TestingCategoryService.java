package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.vti.testing.entity.TestingCategory;

/**
 * This class is Testing Category service.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public interface TestingCategoryService {

	/**
	 * This method uses for getting all Testing Category.
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
	public Page<TestingCategory> getAllTestingCategories(Specification<TestingCategory> specification,
			Pageable pageable);

	/**
	 * This method uses for getting TestingCategory by id.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param id
	 * @return TestingCategory
	 */
	public TestingCategory getTestingCategoryByID(short id);

	/**
	 * This method uses for creating TestingCategory .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param entity
	 */
	public void createTestingCategory(TestingCategory entity);

	/**
	 * This method uses for updating TestingCategory .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param entity
	 */
	public void updateTestingCategory(TestingCategory entity);

	/**
	 * This method uses for deleting TestingCategory .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param id
	 */
	public void deleteTestingCategory(short id);

	/**
	 * This method is checked TestingCategory exists by id .
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
	public boolean existsTestingCategory(short id);

	/**
	 * This method is checked TestingCategory exists by name .
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
	public boolean existsTestingCategory(String name);
}
