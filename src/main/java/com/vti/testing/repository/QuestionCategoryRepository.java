package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.testing.entity.QuestionCategory;

/**
 * This class is Question Category repository.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public interface QuestionCategoryRepository
		extends JpaRepository<QuestionCategory, Short>, JpaSpecificationExecutor<QuestionCategory> {

	/**
	 * This method use for getting Question Category by name.
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
	public QuestionCategory findByName(String name);

	/**
	 * This method is checked Question Category exists by name
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
