package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.vti.testing.entity.QuestionCategory;

/**
 * This class is Question Category service.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public interface QuestionCategoryService {

	/**
	 * This method uses for getting all Question Category.
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
	public Page<QuestionCategory> getAllQuestionCategories(Specification<QuestionCategory> specification,
			Pageable pageable);

	/**
	 * This method uses for getting QuestionCategory by id.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param id
	 * @return QuestionCategory
	 */
	public QuestionCategory getQuestionCategoryByID(short id);

	/**
	 * This method uses for creating QuestionCategory .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param entity
	 */
	public void createQuestionCategory(QuestionCategory entity);

	/**
	 * This method uses for updating QuestionCategory .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param entity
	 */
	public void updateQuestionCategory(QuestionCategory entity);

	/**
	 * This method uses for deleting QuestionCategory .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 15, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 15, 2020
	 * @param id
	 */
	public void deleteQuestionCategory(short id);

	/**
	 * This method is checked QuestionCategory exists by id .
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
	public boolean existsQuestionCategory(short id);

	/**
	 * This method is checked QuestionCategory exists by name .
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
	public boolean existsQuestionCategory(String name);
}
