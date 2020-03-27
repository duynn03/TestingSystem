//
package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.testing.entity.Answer;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 24, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 24, 2020
 */
public interface AnswerRepository extends JpaRepository<Answer, Short>, JpaSpecificationExecutor<Answer> {

}
