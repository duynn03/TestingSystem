package com.vti.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.testing.entity.Exam;
import com.vti.testing.service.ExamService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/exams")
public class ExamController {
	@Autowired
	private ExamService service;

	/**
	 * This method is got all Exam.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 7, 2019
	 * @return List<Question>
	 */
	@GetMapping()
	public ResponseEntity<Page<?>> getAllExam(@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults({
			@SortDefault(sort = "id", direction = Sort.Direction.ASC) }) Pageable pageable) {
		Page<Exam> exam = service.getAllExam(pageable);
		return new ResponseEntity<>(exam, HttpStatus.OK);
	}

	/**
	 * This method is got Exam by ID.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 7, 2019
	 * @param id
	 * @return Question
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getExamByID(@PathVariable(name = "id") int id) {
		Exam exam = service.getExamById(id);
		return new ResponseEntity<>(exam, HttpStatus.OK);
	}

	/**
	 * This method is created Question.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 7, 2019
	 * @param form
	 */
	@PostMapping()
	public ResponseEntity<?> createExam(@RequestBody Exam exam) {
		service.createExam(exam);
		return new ResponseEntity<>("Create success!", HttpStatus.OK);
	}

	/**
	 * This method is updated Question.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 13, 2019
	 * @param form
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateExam(@PathVariable(name = "id") int id, @RequestBody Exam exam) {
		service.updateExam(id, exam);
		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * This method is deleted Question.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer_date: Dec 13, 2019
	 * @param id
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteExam(@PathVariable(name = "id") int id) {
		service.deleteExam(id);
		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}

}
