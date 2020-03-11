//
package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.testing.entity.Exam;

/**
 * This interface is ExamRepository.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 10, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 10, 2020
 */
public interface ExamRepository extends JpaRepository<Exam, Integer> {

	/**
	 * This method is checked Exam exists by name.
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
	public boolean existsByName(String name);

	/**
	 * This method is get exam by name.
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
	public Exam findByName(String name);
}
