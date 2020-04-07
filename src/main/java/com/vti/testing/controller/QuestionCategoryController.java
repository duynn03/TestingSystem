package com.vti.testing.controller;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.testing.dto.questioncategory.QuestionCategoryDto;
import com.vti.testing.entity.QuestionCategory;
import com.vti.testing.service.QuestionCategoryService;
import com.vti.testing.specification.SpecificationTemplate;
import com.vti.testing.validation.Search;

import io.swagger.annotations.ApiOperation;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Mar 27, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Mar 27, 2020
 */
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/questionCategories")
public class QuestionCategoryController {

	@Autowired
	private QuestionCategoryService service;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * This method is get All QuestionCategories.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 27, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 27, 2020
	 * @return
	 */
	@ApiOperation(value = "View a list of available Question Category", response = Page.class)
	@GetMapping()
	public ResponseEntity<?> getAllQuestionCategories(Pageable pageable, @Search String search) throws ParseException {

		// filter
		Specification<QuestionCategory> specification = SpecificationTemplate.buildSpecification(search);

		// get page entity
		Page<QuestionCategory> entityPage = service.getAllQuestionCategories(specification, pageable);

		// Convert entity to dto
		Page<QuestionCategoryDto> dtoPage = convertEntityPageToDtoPage(entityPage, pageable);
		// return page dto
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	/**
	 * This method is Page.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Apr 7, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Apr 7, 2020
	 * @param entityPage
	 * @param pageable
	 * @return
	 */
	private Page<QuestionCategoryDto> convertEntityPageToDtoPage(Page<QuestionCategory> entityPage, Pageable pageable) {
		// get list TestingCategory
		List<QuestionCategory> entities = entityPage.getContent();

		// create conversion type
		Type listType = new TypeToken<List<QuestionCategoryDto>>() {
		}.getType();

		// convert list entities to dtos
		List<QuestionCategoryDto> dtos = modelMapper.map(entities, listType);

		// return page dto
		return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
	}

	/**
	 * This method is got QuestionCategory by ID.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param id
	 * @return QuestionCategory
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getQuestionCategoryByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<>("View Detail ok", HttpStatus.OK);
	}

	/**
	 * This method is created QuestionCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param form
	 */
	@PostMapping()
	public ResponseEntity<?> createQuestionCategory() {
		return new ResponseEntity<>("Create success!", HttpStatus.OK);
	}

	/**
	 * This method is updated QuestionCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 13, 2019
	 * @param form
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateQuestionCategory() {

		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * This method is deleted QuestionCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 13, 2019
	 * @param id
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteQuestionCategory() {

		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}

}
