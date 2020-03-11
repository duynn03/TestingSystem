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

import com.vti.testing.entity.Question;
import com.vti.testing.form.QuestionForm;
import com.vti.testing.service.QuestionService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/questions")
public class QuestionController {

	@Autowired
	private QuestionService service;

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
		Page<Question> question = service.getAllQuestion(pageable);

		return new ResponseEntity<>(question, HttpStatus.OK);
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
		return new ResponseEntity<>("View Detail ok", HttpStatus.OK);
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
		service.createQuestion(form);
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
