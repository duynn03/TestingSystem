package com.vti.testing.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.vti.testing.service.QuestionCategoryService;

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
	public ResponseEntity<?> getAllQuestionCategories() {

		// return page dto
		return new ResponseEntity<>("viewList", HttpStatus.OK);
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
