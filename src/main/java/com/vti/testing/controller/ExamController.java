package com.vti.testing.controller;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.testing.customUser.Principal;
import com.vti.testing.dto.Exam.ExamDto;
import com.vti.testing.dto.Exam.User.ExamUserDto;
import com.vti.testing.entity.Exam;
import com.vti.testing.form.Exam.ExamForm;
import com.vti.testing.service.ExamService;
import com.vti.testing.specification.SpecificationTemplate;
import com.vti.testing.validation.Search;
import com.vti.testing.validation.form.Exam.ExamIDExists;
import com.vti.testing.validation.form.Exam.ExamStatusDraft;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Exam Management", description = "Including API to manipulate Exam")
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
	@ApiOperation(value = "View a list of available Exam", response = Page.class)
	@GetMapping()
	public ResponseEntity<Page<?>> getAllExam(Pageable pageable, @Search String search) throws ParseException {
		// filter
		Specification<Exam> specification = SpecificationTemplate.buildSpecification(search);
		// get page entity
		Page<Exam> exam = service.getAllExam(pageable, specification);

		if (Principal.getRoleManager()) {

			// covert entity to dto
			Page<ExamDto> dtopage = convertEntityPageToDtoPage(exam, pageable);
			return new ResponseEntity<>(dtopage, HttpStatus.OK);

		} else {

			// covert entity to dto
			Page<ExamUserDto> dtopage = convertEntityPageToUserDtoPage(exam, pageable);

			return new ResponseEntity<>(dtopage, HttpStatus.OK);
		}
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
	 * @return Page<ExamUserDto>
	 */
	private Page<ExamUserDto> convertEntityPageToUserDtoPage(Page<Exam> entityPage, Pageable pageable) {
		// get list TestingCategory
		List<Exam> entities = entityPage.getContent();

		// create conversion type
		Type listType = new TypeToken<List<ExamUserDto>>() {
		}.getType();

		// convert list entities to dtos
		List<ExamUserDto> dtos = modelMapper.map(entities, listType);

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
	@ApiOperation(value = "Get a Exam By ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getExamByID(
			@ApiParam(value = "Exam's id from which Exam object will retrieve") @PathVariable(name = "id") @ExamIDExists int id) {

		// get exam
		Exam exam = service.getExamById(id);

		if (Principal.getRole().equals("[ROLE_MANAGER]")) {
			// convert entity to dto
			ExamDto dto = modelMapper.map(exam, ExamDto.class);
			return new ResponseEntity<>(dto, HttpStatus.OK);

		} else {
			// convert entity to ExamUserdto
			ExamUserDto dto = modelMapper.map(exam, ExamUserDto.class);
			return new ResponseEntity<>(dto, HttpStatus.OK);

		}

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
	@ApiOperation(value = "Add a Exam")
	@PostMapping()
	@Validated(onCreate.class)
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public ResponseEntity<?> createExam(
			@ApiParam(value = "Form to create Exam", required = true) @Valid @RequestBody ExamForm form) {

		Exam exam = modelMapper.map(form, Exam.class);
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
	@ApiOperation(value = "Delete a Exam By ID")
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public ResponseEntity<?> deleteExam(
			@ApiParam(value = "Exam's Id from which Exam object will delete from database table", required = true) @ExamStatusDraft @ExamIDExists @PathVariable(name = "id") int id) {
		service.deleteExam(id);
		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}

}
