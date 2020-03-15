package com.vti.testing.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.testing.dto.ExamDto;
import com.vti.testing.entity.Exam;
import com.vti.testing.entity.Testing;
import com.vti.testing.entity.User;
import com.vti.testing.form.ExamForm;
import com.vti.testing.service.ExamService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/exams")
public class ExamController {
	@Autowired
	private ExamService service;
	@Autowired
	private ModelMapper modelMapper;

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

		// get page entity
		Page<Exam> exam = service.getAllExam(pageable);

		// covert entity to dto
		Page<ExamDto> dtopage = convertEntityPageToDtoPage(exam, pageable);
		return new ResponseEntity<>(dtopage, HttpStatus.OK);
	}

	/**
	 * This method is converted entity page to dto page.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Mar 11, 2020
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Mar 11, 2020
	 * @param entityPage
	 * @param pageable
	 * @return Page<Dto>
	 */
	private Page<ExamDto> convertEntityPageToDtoPage(Page<Exam> entityPage, Pageable pageable) {
		// get list TestingCategory
		List<Exam> entities = entityPage.getContent();

		// create conversion type
		Type listType = new TypeToken<List<ExamDto>>() {
		}.getType();

		// convert list entities to dtos
		List<ExamDto> dtos = modelMapper.map(entities, listType);

		// return page dto
		return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
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
		// get exam by id
		// check exam
		if (service.existsExamByID(id)) {
			Exam exam = service.getExamById(id);

			// convert entity to dto
			ExamDto dto = modelMapper.map(exam, ExamDto.class);
			return new ResponseEntity<>(dto, HttpStatus.OK);

		}
		return new ResponseEntity<>("Exam not exists!!!", HttpStatus.NOT_FOUND);
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
	public ResponseEntity<?> createExam(@RequestBody ExamForm form) {
		// get exam by name
		// check exam
		if (!service.existsExamByName(form.getName())) {
			Exam exam = modelMapper.map(form, Exam.class);
			// set child element
			if (exam.getAuthor() != null) {
				User user = exam.getAuthor();
				List<Exam> listExam = new ArrayList<Exam>();
				listExam.add(exam);
				user.setExamAuthors(listExam);
			}
			if (exam.getTestings() != null) {
				for (Testing testing : exam.getTestings()) {
					List<Exam> listExam = new ArrayList<Exam>();
					listExam.add(exam);
					testing.setExams(listExam);
				}
			}

			service.createExam(exam);
			return new ResponseEntity<>("Create success!", HttpStatus.OK);

		}
		return new ResponseEntity<>("Create Fail!", HttpStatus.PRECONDITION_FAILED);
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
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<?> updateExam(@PathVariable(name = "id") int id, @RequestBody Exam exam) {
//		service.updateExam(id, exam);
//		return new ResponseEntity<>("Update success!", HttpStatus.OK);
//	}

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

		// get exam by id
		// check exam
		if (service.existsExamByID(id)) {
			service.deleteExam(id);
			return new ResponseEntity<>("Delete success!", HttpStatus.OK);

		}
		return new ResponseEntity<>("Delete Fail!", HttpStatus.BAD_REQUEST);
	}

}
