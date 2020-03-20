package com.vti.testing.controller;

import java.lang.reflect.Type;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.testing.dto.TestingTemplateDto;
import com.vti.testing.entity.Answer;
import com.vti.testing.entity.Exam;
import com.vti.testing.entity.Question;
import com.vti.testing.entity.Testing;
import com.vti.testing.form.QuestionForm;
import com.vti.testing.form.TestingTemplateForm;
import com.vti.testing.service.TestingTemplateService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/testingtemplate")
public class TestingTemplateController {

	@Autowired
	private TestingTemplateService service;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * 
	 * This method is got all TestingTemplate.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 18, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 18, 2020
	 * @param pageable
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<?> getAllTestingTemplate(@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults({
			@SortDefault(sort = "id", direction = Sort.Direction.ASC) }) Pageable pageable) {

		// get page entity
		Page<Testing> entityPage = service.getAllTestingTemplate(pageable);

		// Convert entity to dto
		Page<TestingTemplateDto> dtoPage = convertEntityPageToDtoPage(entityPage, pageable);

		// return page dto
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param entityPage
	 * @param pageable
	 * @return
	 */
	private Page<TestingTemplateDto> convertEntityPageToDtoPage(Page<Testing> entityPage, Pageable pageable) {
		// get list Question
		List<Testing> entities = entityPage.getContent();

		// create conversion type
		Type listType = new TypeToken<List<TestingTemplateDto>>() {
		}.getType();

		// convert list entities to list dto
		List<TestingTemplateDto> dtos = modelMapper.map(entities, listType);

		// return page dto
		return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
	}

	/**
	 * 
	 * This method is got testingtemplate by ID.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 18, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 18, 2020
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getTestingTemplateByID(@PathVariable(name = "id") short id) {
		// get entity
		Testing entity = service.getTestingByID(id);

		// convert entity to dto
		TestingTemplateDto dto = modelMapper.map(entity, TestingTemplateDto.class);

		// return result
		return new ResponseEntity<>(dto.toString(), HttpStatus.OK);
	}

	/**
	 * 
	 *This method is created Question.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 18, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 18, 2020
	 * @param form
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<?> createTestingTemplate(@RequestBody TestingTemplateForm form) {

		// convert form to entity
		Testing entity = modelMapper.map(form, Testing.class);

		// set child element
		if(null != entity.getExams()) {
			for(Exam exam : entity.getExams()) {
			//	exam.setTestings(entity)
			}
		}

		// return result
		return new ResponseEntity<>("Create success!", HttpStatus.OK);
	}

	/**
	 * 
	 * This method is updated Question.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 18, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 18, 2020
	 * @return
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateTestingTemplate() {

		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * 
	 *  This method is deleted Question.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 18, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 18, 2020
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteTestingTemplate() {

		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}

}
