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

import com.vti.testing.entity.TestingCategory;
import com.vti.testing.form.TestingCategoryForm;
import com.vti.testing.service.TestingCategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/testingcategories")
public class TestingCategoryController {

	@Autowired
	private TestingCategoryService service;

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
	public ResponseEntity<Page<?>> getAllTestingCategories(
			@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults({
					@SortDefault(sort = "id", direction = Sort.Direction.ASC) }) Pageable pageable) {
		Page<TestingCategory> categories = service.getAllTestingCategories(pageable);
		return new ResponseEntity<>(categories, HttpStatus.OK);
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
		TestingCategory category = service.getTestingCategoryByID(id);
		return new ResponseEntity<>(category, HttpStatus.OK);
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
	public ResponseEntity<?> createTestingCategory(@RequestBody TestingCategoryForm form) {
		service.createTestingCategory(form);
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
	public ResponseEntity<?> updateTestingCategory(@PathVariable(name = "id") short id,
			@RequestBody TestingCategoryForm form) {
		service.updateTestingCategory(id, form);
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
	public ResponseEntity<?> deleteTestingCategory(@PathVariable(name = "id") short id) {
		service.deleteTestingCategory(id);
		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}

}
