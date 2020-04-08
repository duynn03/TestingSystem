package com.vti.testing.controller;

import java.lang.reflect.Type;
import java.text.ParseException;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
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

import com.vti.testing.dto.question.QuestionDto;
import com.vti.testing.entity.Answer;
import com.vti.testing.entity.Question;
import com.vti.testing.entity.QuestionCategory;
import com.vti.testing.form.question.QuestionForm;
import com.vti.testing.form.question.QuestionFormUpdate;
import com.vti.testing.form.testingcategory.QuestionCategoryForm;
import com.vti.testing.service.QuestionService;
import com.vti.testing.specification.SpecificationTemplate;
import com.vti.testing.validation.Search;
import com.vti.testing.validation.form.question.QuestionIDExists;
import com.vti.testing.validation.form.question.QuestionUpdatingByQuestionCategory;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Testing Category Management")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/questions")
@Validated
public class QuestionController {

	@Autowired
	private QuestionService service;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * 
	 * This method is got all Questions.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param pageable
	 * @return
	 */
	@ApiOperation(value = "View a list of available Question", response = Page.class)
	@GetMapping()
	public ResponseEntity<Page<?>> getAllQuestions(Pageable pageable, @Search String search) throws ParseException {

		// filter
		Specification<Question> specification = SpecificationTemplate.buildSpecification(search);

		// get page entity
		Page<Question> entityPage = service.getAllQuestion(specification, pageable);

		// Convert entity to dto
		Page<QuestionDto> dtoPage = convertEntityPageToDtoPage(entityPage, pageable);

		// return page dto
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	/**
	 * This method is converted entity page to dto page.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 18, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 18, 2020
	 * @param entityPage
	 * @param pageable
	 * @return
	 */
	private Page<QuestionDto> convertEntityPageToDtoPage(Page<Question> entityPage, Pageable pageable) {

		// get list TestingCategory
		List<Question> entities = entityPage.getContent();

		// create conversion type
		Type listType = new TypeToken<List<QuestionDto>>() {
		}.getType();

		// convert list entities to dtos
		List<QuestionDto> dtos = modelMapper.map(entities, listType);

		// return page dto
		return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
	}

	/**
	 * 
	 * This method is got Question by ID.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Get a Question By ID", response = QuestionDto.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getQuestionByID(
			@ApiParam(value = "Get question by id") @QuestionIDExists @PathVariable(name = "id") short id) {
		// get entity
		Question entity = service.getQuestionByID(id);
		// used to match source properties to destination properties.
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		// convert entity to dto
		QuestionDto dto = modelMapper.map(entity, QuestionDto.class);

		// return result
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	/**
	 * 
	 * This method is created Question.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param form
	 * @return
	 */
	@ApiOperation(value = "Add a Question")
	@PostMapping()
	@Validated(onCreate.class)
	public ResponseEntity<?> createQuestion(
			@ApiParam(value = "Form to create Question", required = true) @Valid @RequestBody QuestionForm form) {

		// convert form to entity
		Question entity = modelMapper.map(form, Question.class);

		// set child element
		if (null != entity.getAnswers()) {
			for (Answer answer : entity.getAnswers()) {
				answer.setQuestion(entity);
			}
		}

		// create testing category
		service.createQuestion(entity);

		// return result
		return new ResponseEntity<>("Create success!", HttpStatus.OK);
	}

	/**
	 * 
	 * This method is updated Question by title.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param id
	 * @param form
	 * @return
	 */
	@ApiOperation(value = "Update Question By Title")
	@PutMapping(value = "/{id}/title")
	public ResponseEntity<?> updateQuestionByTitle(
			@ApiParam(value = "Update question ", required = true) 
			@QuestionIDExists @PathVariable(name = "id") short id,
			@RequestBody Map<String, Object> body) {

		Question entity = service.getQuestionByID(id);
		
		
	//	QuestionForm form = 
	//	Question temp = new Question();
		
		
		
		return new ResponseEntity<>("Update success !", HttpStatus.OK);
//		Question entity = service.getQuestionByID(id);
//		if (entity.getQuestionTotal() < 1) {
//			QuestionForm form2 = questionForm;
//
//			form2.updateQuestion(entity);
//
//			Question question = modelMapper.map(form2, Question.class);
//
//			service.createQuestion(question);
//
//			return new ResponseEntity<>("Update success !", HttpStatus.OK);
//		}
//		return new ResponseEntity<>("Update failed. It seems that the question is on some test !", HttpStatus.OK);
	}

	/**
	 * 
	 * This method is update question by question category.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Apr 5, 2020
	 * @param id
	 * @param questionCategory
	 * @return
	 */
	@ApiOperation(value = "Update Question By  Question Category")
	@PutMapping(value = "/{id}/questioncategory")
	public ResponseEntity<?> updateQuestionByQuestionCategory(
			@ApiParam(value = "Question's Id to update Question object", required = true) @QuestionIDExists @PathVariable(name = "id") short id,
			@ApiParam(value = "Form to update  Question Categories of Question", required = true) @RequestBody @QuestionUpdatingByQuestionCategory QuestionCategoryForm questionCategory) {

		// Convert QuestionCategoryForm to QuestionCategoryEntity
		QuestionCategory questionCategoryEntity = convertQuestionCategoryFormsToEntity(questionCategory);

		Question entity = setQuestionCategoryToQuestion(id, questionCategoryEntity);

		// update Testingcategory
		service.updateQuestion(entity);

		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * This method is convert QuestionCategory Forms To Entity.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Apr 5, 2020
	 * @param questionCategory
	 * @return
	 */
	private QuestionCategory convertQuestionCategoryFormsToEntity(QuestionCategoryForm form) {

		Type type = new TypeToken<QuestionCategory>() {
		}.getType();

		return modelMapper.map(form, type);
	}

	/**
	 * This method is set question category for question.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Apr 5, 2020
	 * @param id
	 * @param questionCategoryEntity
	 * @return
	 */
	private Question setQuestionCategoryToQuestion(short id, QuestionCategory questionCategoryEntity) {

		// get question by id
		Question entity = service.getQuestionByID(id);

		// set Question category
		return entity.setQuestionCategory(questionCategoryEntity);

	}

	/**
	 * 
	 * This method is deleted Question.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 17, 2020
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Delete a Question By ID")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable(name = "id") short id) {
		if (service.deleteQuestion(id) == true) {
			return new ResponseEntity<>("Delete success!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The question cannot be deleted because it is on the Testing Template",
					HttpStatus.OK);
		}
	}

}
