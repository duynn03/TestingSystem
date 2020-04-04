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
import org.springframework.context.ApplicationEventPublisher;
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

import com.vti.testing.config.registration.OnRegistrationUserCompleteEvent;
import com.vti.testing.dto.user.UserDto;
import com.vti.testing.entity.RegistrationUserToken;
import com.vti.testing.entity.User;
import com.vti.testing.entity.enumerate.UserStatus;
import com.vti.testing.form.user.UserForm;
import com.vti.testing.service.UserService;
import com.vti.testing.specification.SpecificationTemplate;
import com.vti.testing.validation.Search;
import com.vti.testing.validation.form.user.RegistrationUserTokenActive;
import com.vti.testing.validation.form.user.RegistrationUserTokenExists;
import com.vti.testing.validation.form.user.UserIDExists;
import com.vti.testing.validation.form.user.UserNameNotExists;
import com.vti.testing.validation.group.onCreate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "User Management", description = "Including API to manipulate User")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/Users")
@Validated
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	/**
	 * This method is get All Users.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 25, 2020
	 * @param pageable
	 * @param search
	 * @return
	 * @throws ParseException
	 */
	@ApiOperation(value = "View a list of available User", response = Page.class)
	@GetMapping()
	public ResponseEntity<?> getAllUsers(Pageable pageable, @Search String search) throws ParseException {

		// filter
		Specification<User> specification = SpecificationTemplate.buildSpecification(search);

		// get page entity
		Page<User> entityPage = service.getAllUsers(specification, pageable);

		// Convert entity to dto
		Page<UserDto> dtoPage = convertEntityPageToDtoPage(entityPage, pageable);

		// return page dto
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	/**
	 * This method is convert Entity Page ToDto Page.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 25, 2020
	 * @param entityPage
	 * @param pageable
	 * @return
	 */
	private Page<UserDto> convertEntityPageToDtoPage(Page<User> entityPage, Pageable pageable) {
		// get list TestingCategory
		List<User> entities = entityPage.getContent();

		// create conversion type
		Type listType = new TypeToken<List<UserDto>>() {
		}.getType();

		// convert list entities to dtos
		List<UserDto> dtos = modelMapper.map(entities, listType);

		// return page dto
		return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
	}

	/**
	 * This method is got User by ID.
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
	@ApiOperation(value = "Get a User By ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getUserByID(
			@ApiParam(value = "User's id from which User object will retrieve") @UserIDExists @PathVariable(name = "id") int id) {
		{
			// get entity
			User entity = service.getUserByID(id);

			// convert entity to dto
			UserDto dto = modelMapper.map(entity, UserDto.class);

			// return result
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
	}

	/**
	 * This method is created User.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param form
	 */
	@ApiOperation(value = "Add a User")
	@PostMapping()
	@Validated(onCreate.class)
	public ResponseEntity<?> createUser(
			@ApiParam(value = "Form to create User", required = true) @Valid @RequestBody UserForm form) {

		// convert form to entity
		User entity = modelMapper.map(form, User.class);

		// create User
		User registeredUser = service.createUser(entity);

		// Create the Token and Send the Registration Confirm to User's Email
		eventPublisher.publishEvent(new OnRegistrationUserCompleteEvent(registeredUser));

		return new ResponseEntity<>("Create success!", HttpStatus.OK);
	}

	@ApiOperation(value = "Confirm registration via Email")
	@GetMapping("/registrationConfirm/{token}")
	public ResponseEntity<?> confirmRegistrationViaEmail(
			@ApiParam(value = "Token to confirm registration", required = true) @RegistrationUserTokenActive @RegistrationUserTokenExists @PathVariable(name = "token") String token) {

		// get token
		RegistrationUserToken registrationToken = service.getToken(token);

		User user = registrationToken.getUser();

		user.setStatus(UserStatus.ACTIVE);
		service.updateUser(user);

		return new ResponseEntity<>("Confirm success!", HttpStatus.OK);
	}

	/**
	 * This method is updated User.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 13, 2019
	 * @param form
	 */
	@ApiOperation(value = "Update a User By ID")
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateUser(
			@ApiParam(value = "User's Id to update UserName object", required = true) @UserNameNotExists @PathVariable(name = "id") short id,
			@RequestBody Map<String, String> body) {

		// get name
		@NotEmpty
		@Size(max = 50)
		String userName = body.get("username");

		// convert form to entity
		User entity = service.getUserByID(id);
		entity.setUserName(userName);

		// update User
		service.updateUser(entity);

		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * This method is deleted User.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 13, 2019
	 * @param id
	 */
	@ApiOperation(value = "Delete a User By ID")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUser(
			@ApiParam(value = "User's Id from which User object will delete from database table", required = true) @UserIDExists @PathVariable(name = "id") int id) {
		service.deleteUser(id);

		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}
}
