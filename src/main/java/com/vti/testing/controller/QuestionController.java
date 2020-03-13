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

import com.vti.testing.dto.QuestionDto;
import com.vti.testing.entity.Question;
import com.vti.testing.form.QuestionForm;
import com.vti.testing.service.QuestionService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/questions")
public class QuestionController {

	@Autowired
	private QuestionService service;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * This method is got all Questions.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @return List<Question>
	 */
	@GetMapping()
	public ResponseEntity<Page<?>> getAllQuestions(@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults({
			@SortDefault(sort = "id", direction = Sort.Direction.ASC) }) Pageable pageable) {

		// get page entity
		Page<Question> entityPage = service.getAllQuestion(pageable);

		// Convert entity to dto
		Page<QuestionDto> dtoPage = convertEntityPageToDtoPage(entityPage, pageable);

		// return page dto
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	/**
	 * 
	 * This method is convert entity page to dto page.
	 * 
	 * @Description: .
	 * @author: HVHanh
	 * @create_date: Mar 11, 2020
	 * @version: 1.0
	 * @modifer: HVHanh
	 * @modifer_date: Mar 11, 2020
	 * @param entityPage
	 * @param pageable
	 * @return
	 */
	private Page<QuestionDto> convertEntityPageToDtoPage(Page<Question> entityPage, Pageable pageable) {

		// get list Question
		List<Question> entities = entityPage.getContent();

		// create conversion type
		Type listType = new TypeToken<List<QuestionDto>>() {
		}.getType();

		// convert list entities to list dto
		List<QuestionDto> dtos = modelMapper.map(entities, listType);

		// return page dto
		return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
	}

	/**
	 * This method is got Question by ID.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param id
	 * @return Question
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getQuestionByID(@PathVariable(name = "id") short id) {
		// get entity
		Question entity = service.getQuestionByID(id);

		// convert entity to dto
		Question dto = modelMapper.map(entity, Question.class);

		// return result
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	/**
	 * This method is created Question.
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
	public ResponseEntity<?> createQuestion(@RequestBody QuestionForm form) {
		// convert form to entity
		Question entity = modelMapper.map(form, Question.class);

		// create testing category
		service.createQuestion(entity);

		// return result
		return new ResponseEntity<>("Create success!", HttpStatus.OK);
	}

	/**
	 * This method is updated Question.
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
	public ResponseEntity<?> updateQuestion() {

		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * This method is deleted Question.
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
	public ResponseEntity<?> deleteQuestion() {

		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}

}
