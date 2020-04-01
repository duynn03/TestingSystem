//
package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.vti.testing.entity.Question;
import com.vti.testing.entity.TestingCategory;
import com.vti.testing.form.QuestionForm;

/**
 * This class is interface of QuestionService .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 5, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 5, 2020
 */
public interface QuestionService {

	/**
	 * 
	 * This method is getAll question.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 6, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 6, 2020
	 * @param pageable
	 * @return
	 */
	public Page<Question> getAllQuestion(Specification<Question> specification,
			Pageable pageable);

	/**
	 * 
	 * This method is get question by is .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 6, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 6, 2020
	 * @param id
	 * @return
	 */
	public Question getQuestionByID(Short id);

	/**
	 * 
	 * This method is create question .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 6, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 6, 2020
	 */
	public void createQuestion(Question entity);

	/**
	 * 
	 * This method is update question .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 6, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 6, 2020
	 * @param id
	 * @param form
	 */
	public void updateQuestion( Question entity);

	/**
	 * 
	 * This method is delete question.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 6, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 6, 2020
	 * @param id
	 * @return 
	 */
	public boolean deleteQuestion(short id);

	/**
	 * 
	 * This method is exists Question by id .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 6, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 6, 2020
	 * @param id
	 * @return
	 */
	public boolean existsQuestion(short id);

	/**
	 * 
	 * This method is exists question by name .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 6, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 6, 2020
	 * @param name
	 * @return
	 */
//	public boolean existsQuestion(String name);

}
