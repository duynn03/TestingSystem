package com.vti.testing.controller;

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

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/testingcategories")
public class TestingCategoryController {

	/**
	 * This method is got all TestingCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @return List<TestingCategory>
	 */
	@GetMapping()
	public ResponseEntity<?> getAllTestingCategories() {

		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

	/**
	 * This method is got TestingCategory by ID.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param id
	 * @return TestingCategory
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getTestingCategoryByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

	/**
	 * This method is created TestingCategory.
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
	public ResponseEntity<?> createTestingCategory() {
		return new ResponseEntity<>("Create success!", HttpStatus.OK);
	}

	/**
	 * This method is updated TestingCategory.
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
	public ResponseEntity<?> updateTestingCategory() {

		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * This method is deleted TestingCategory.
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
	public ResponseEntity<?> deleteTestingCategory() {

		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}

}
