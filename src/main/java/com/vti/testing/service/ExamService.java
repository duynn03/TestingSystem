//
package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.vti.testing.entity.Exam;

/**
 * This interface is Exam Service.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 10, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 10, 2020
 */
public interface ExamService {
	/**
	 * This method is get all exam.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 10, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 10, 2020
	 * @param pageable
	 * @return List<Exam>
	 */
	public Page<Exam> getAllExam(Pageable pageable, Specification<Exam> specification);

	/**
	 * This method is for getting Exam by id.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 10, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 10, 2020
	 * @param ID
	 * @return
	 */
	public Exam getExamById(int ID);

	/**
	 * This method is for creating Exam.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 10, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 10, 2020
	 * @param exam
	 * @return
	 */
	public void createExam(Exam exam);

	/**
	 * This method is for updating Exam.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 10, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 10, 2020
	 * @param ID
	 * @param exam
	 * @return
	 */
	public void updateExam(int ID, Exam exam);

	/**
	 * This method is for deleting Exam.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 10, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 10, 2020
	 * @param ID
	 * @return
	 */
	public void deleteExam(int ID);

	/**
	 * This method is checked Exam exists by ID .
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 10, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 10, 2020
	 * @param id
	 * @return
	 */
	public boolean existsExamByID(int id);

	/**
	 * This method is checked Exam exists by name .
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 10, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 10, 2020
	 * @param name
	 * @return
	 */
	public boolean existsExamByName(String name);
	
}
