package com.vti.testing.controller;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.testing.dto.TestingCategoryDto;
import com.vti.testing.entity.QuestionCategory;
import com.vti.testing.entity.TestingCategory;
import com.vti.testing.form.testingcategory.QuestionCategoryForm;
import com.vti.testing.form.testingcategory.TestingCategoryForm;
import com.vti.testing.service.TestingCategoryService;
import com.vti.testing.specification.SpecificationTemplate;
import com.vti.testing.validation.Search;
import com.vti.testing.validation.form.testingcategory.TestingCategoryIDExists;
import com.vti.testing.validation.form.testingcategory.TestingCategoryNameNotExists;
import com.vti.testing.validation.form.testingcategory.TestingCategoryUpdatingByQuestionCategories;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Testing Category Management", description = "Including API to manipulate Testing Category")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/testingcategories")
@Validated
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
	 * @throws ParseException
	 */
	@ApiOperation(value = "View a list of available Testing Category", response = Page.class)
	@GetMapping()
	public ResponseEntity<Page<?>> getAllTestingCategories(Pageable pageable, @Search String search)
			throws ParseException {

		// filter
		Specification<TestingCategory> specification = SpecificationTemplate.buildSpecification(search);

		// get page entity
		Page<TestingCategory> entityPage = service.getAllTestingCategories(specification, pageable);

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
	@ApiOperation(value = "Get a Testing Category By ID", response = TestingCategoryDto.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getTestingCategoryByID(
			@ApiParam(value = "Testing Category's id from which Testing Category object will retrieve") @TestingCategoryIDExists @PathVariable(name = "id") short id) {
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
	@ApiOperation(value = "Add a Testing Category")
	@PostMapping()
	@Validated(onCreate.class)
	public ResponseEntity<?> createTestingCategory(
			@ApiParam(value = "Form to create Testing Category", required = true) @Valid @RequestBody TestingCategoryForm form) {
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
	 * This method is updated TestingCategory by name.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 13, 2019
	 * @param form
	 * @param body
	 */
	@ApiOperation(value = "Update Testing Category's Name")
	@PutMapping(value = "/{id}/name")
	public ResponseEntity<?> updateTestingCategoryByName(
			@ApiParam(value = "Testing Category's Id to update TestingCategory object", required = true) 
			@TestingCategoryIDExists @PathVariable(name = "id") short id,
			@RequestBody Map<String, String> body) {

		// get name
		@NotEmpty
		@Size(max = 50)
		@TestingCategoryNameNotExists
		String name = body.get("name");

		// convert form to entity
		TestingCategory entity = service.getTestingCategoryByID(id);
		entity.setName(name);

		// update Testingcategory
		service.updateTestingCategory(entity);

		// return result
		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * This method is updated TestingCategory by question category list.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 13, 2019
	 * @param form
	 * @param body
	 */
	@ApiOperation(value = "Update Testing Category's Question Categories")
	@PutMapping(value = "/{id}/questioncategories")
	public ResponseEntity<?> updateTestingCategoryByQuestionCategories(
			@ApiParam(value = "Testing Category's Id to update TestingCategory object", required = true) @TestingCategoryIDExists @PathVariable(name = "id") short id,
			@ApiParam(value = "Form to update List Question Categories of Testing Category", required = true) @RequestBody List<@TestingCategoryUpdatingByQuestionCategories QuestionCategoryForm> questionCategories) {

		// Convert form to entity
		List<QuestionCategory> questionCategoryEntities = convertListQuestionCategoryFormsToListEntities(
				questionCategories);

		// add List questionCategories to TestingCategory
		TestingCategory entity = addQuestionCategoriesToTestingCategory(id, questionCategoryEntities);

		// update Testingcategory
		service.updateTestingCategory(entity);

		// return result
		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * This method is converted List QuestionCategoryForms to List Entities.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 11, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 11, 2020
	 * @param forms
	 * @return List<QuestionCategory>
	 */
	private List<QuestionCategory> convertListQuestionCategoryFormsToListEntities(List<QuestionCategoryForm> forms) {

		// create conversion type
		Type listType = new TypeToken<List<QuestionCategory>>() {
		}.getType();

		// convert List QuestionCategoryForms to List Entities
		return modelMapper.map(forms, listType);
	}

	/**
	 * This method is added List QuestionCategories to TestingCategory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 17, 2020
	 */
	private TestingCategory addQuestionCategoriesToTestingCategory(short id,
			List<QuestionCategory> questionCategories) {
		// get TestingCategory from id
		TestingCategory entity = service.getTestingCategoryByID(id);

		// clear list old questionCategories
		entity.getQuestionCategories().clear();

		// add new questionCategories
		for (QuestionCategory questionCategory : questionCategories) {
			entity.addQuestionCategory(questionCategory);
		}
		return entity;
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
	@ApiOperation(value = "Delete a Testing Category By ID")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteTestingCategory(
			@ApiParam(value = "Testing Category's Id from which TestingCategory object will delete from database table", required = true) @TestingCategoryIDExists @PathVariable(name = "id") short id) {
		service.deleteTestingCategory(id);
		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}

}
