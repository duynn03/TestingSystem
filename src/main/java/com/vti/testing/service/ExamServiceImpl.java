//
package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.testing.entity.Exam;
import com.vti.testing.repository.ExamRepository;

/**
 * This class is implement Exam Service.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 10, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 10, 2020
 */
@Service
public class ExamServiceImpl implements ExamService {
	@Autowired
	private ExamRepository repository;

	/*
	 * @see com.vti.testing.service.ExamService#getAllExam(org.springframework.data.
	 * domain.Pageable)
	 */
	@Override
	public Page<Exam> getAllExam(Pageable pageable, Specification<Exam> specification) {
		return repository.findAll(specification, pageable);
	}

	/*
	 * @see com.vti.testing.service.ExamService#getExamById(int)
	 */
	@Override
	public Exam getExamById(int ID) {
		return repository.findById(ID).get();
	}

	/*
	 * @see
	 * com.vti.testing.service.ExamService#createExam(com.vti.testing.entity.Exam)
	 */
	@Override
	public void createExam(Exam exam) {
		repository.save(exam);
	}

	/*
	 * @see com.vti.testing.service.ExamService#updateExam(int,
	 * com.vti.testing.entity.Exam)
	 */
	@Override
	public void updateExam(int ID, Exam exam) {
		Exam exam1 = getExamById(ID);

		// update name
		if (!StringUtils.isEmpty(exam.getName())) {
			exam1.setName(exam.getName());

		}
		repository.save(exam1);
	}

	/*
	 * @see com.vti.testing.service.ExamService#deleteExam(int)
	 */
	@Override
	public void deleteExam(int ID) {
		repository.deleteById(ID);
	}

	/*
	 * @see com.vti.testing.service.ExamService#existsTestingCategory(int)
	 */
	@Override
	public boolean existsExamByID(int id) {
		return repository.existsById(id);
	}

	/*
	 * @see
	 * com.vti.testing.service.ExamService#existsTestingCategory(java.lang.String)
	 */
	@Override
	public boolean existsExamByName(String name) {
		return repository.existsByName(name);
	}

}
