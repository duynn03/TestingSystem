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

import com.vti.testing.dto.testingcategory.TestingCategoryDto;
import com.vti.testing.entity.QuestionCategory;
import com.vti.testing.entity.TestingCategory;
import com.vti.testing.form.TestingCategoryForm;
import com.vti.testing.service.TestingCategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/testingcategories")
public class TestingCategoryController {

	@Autowired
	private TestingCategoryService service;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * This method is got all TestingCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @return Page<TestingCategory>
	 */
	@GetMapping()
	public ResponseEntity<Page<?>> getAllTestingCategories(
			@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults({
					@SortDefault(sort = "id", direction = Sort.Direction.ASC) }) Pageable pageable) {

		// get page entity
		Page<TestingCategory> entityPage = service.getAllTestingCategories(pageable);

		// Convert entity to dto
		Page<TestingCategoryDto> dtoPage = convertEntityPageToDtoPage(entityPage, pageable);

		// return page dto
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	/**
	 * This method is converted entity page to dto page.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 11, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 11, 2020
	 * @param entityPage
	 * @param pageable
	 * @return Page<Dto>
	 */
	private Page<TestingCategoryDto> convertEntityPageToDtoPage(Page<TestingCategory> entityPage, Pageable pageable) {
		// get list TestingCategory
		List<TestingCategory> entities = entityPage.getContent();

		// create conversion type
		Type listType = new TypeToken<List<TestingCategoryDto>>() {
		}.getType();

		// convert list entities to dtos
		List<TestingCategoryDto> dtos = modelMapper.map(entities, listType);

		// return page dto
		return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
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
		// get entity
		TestingCategory entity = service.getTestingCategoryByID(id);

		// convert entity to dto
		TestingCategoryDto dto = modelMapper.map(entity, TestingCategoryDto.class);

		// return result
		return new ResponseEntity<>(dto, HttpStatus.OK);
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
		// convert form to entity
		TestingCategory entity = modelMapper.map(form, TestingCategory.class);

		// set child element
		if (null != entity.getQuestionCategories()) {
			for (QuestionCategory questionCategory : entity.getQuestionCategories()) {
				questionCategory.setTestingCategory(entity);
			}
		}

		// create testing category
		service.createTestingCategory(entity);

		// return result
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

		// convert form to entity
		TestingCategory entity = modelMapper.map(form, TestingCategory.class);
		entity.setId(id);

		// set child element
		if (null != entity.getQuestionCategories()) {
			for (QuestionCategory questionCategory : entity.getQuestionCategories()) {
				questionCategory.setTestingCategory(entity);
			}
		}

		// update Testingcategory
		service.updateTestingCategory(entity);

		// return result
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
