//

package com.vti.testing.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.testing.entity.Answer;
import com.vti.testing.entity.Question;
import com.vti.testing.form.AnswerForm;
import com.vti.testing.form.question.QuestionForm;
import com.vti.testing.service.AnswerService;

import io.swagger.annotations.ApiParam;

/**
 * This class is answer controller .
 * 
 * @Description: .
 * @author: HVHanh
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: HVHanh
 * @modifer_date: Mar 25, 2020
 */
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/answer")
public class AnswerController {

	@Autowired
	AnswerService service;
	@Autowired
	private ModelMapper modelMapper;

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
	@PostMapping()
	public ResponseEntity<?> createAnswer(
			@ApiParam(value = "Form to create answer", required = true) @Valid @RequestBody AnswerForm form) {

		// convert form to entity
		Answer entity = modelMapper.map(form, Answer.class);

		// create testing category
		service.createAnswer(entity);

		// return result
		return new ResponseEntity<>("Create success!", HttpStatus.OK);
	}
}
