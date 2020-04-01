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

import com.vti.testing.dto.QuestionDto;
import com.vti.testing.entity.Answer;
import com.vti.testing.entity.Question;
import com.vti.testing.form.QuestionForm;
import com.vti.testing.service.QuestionService;
import com.vti.testing.specification.SpecificationTemplate;
import com.vti.testing.validation.Search;
import com.vti.testing.validation.form.question.QuestionIDExists;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/questions")
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
	@ApiOperation(value = "Get a Question By ID")
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
	 * This method is updated Question.
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
	@ApiOperation(value = "Update Question title")
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateQuestion(@PathVariable(name = "id") short id,
			@RequestBody Map<String, String> body) {

		// get title
		@NotEmpty
		String title = body.get("title");

		// convert form to entity
		Question entity = service.getQuestionByID(id);
		entity.setTitle(title);

		service.updateQuestion(entity);

		// update Testingcategory
		service.updateQuestion(entity);

		// return result
		return new ResponseEntity<>("Update success!", HttpStatus.OK);
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
			return new ResponseEntity<>("Cannot delete  a parent row: a foreign key constraint fails", HttpStatus.OK);
		}
	}

}
