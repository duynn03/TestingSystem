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
import org.springframework.data.repository.query.Param;
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

import com.vti.testing.config.user.registrationUser.OnSendRegistrationUserConfirmViaEmailEvent;
import com.vti.testing.config.user.resetPassword.OnResetPasswordViaEmailEvent;
import com.vti.testing.dto.user.UserDto;
import com.vti.testing.entity.User;
import com.vti.testing.form.user.UserForm;
import com.vti.testing.service.UserService;
import com.vti.testing.specification.SpecificationTemplate;
import com.vti.testing.validation.Search;
import com.vti.testing.validation.form.user.RegistrationUserTokenValid;
import com.vti.testing.validation.form.user.ResetPasswordTokenValid;
import com.vti.testing.validation.form.user.UserEmailExists;
import com.vti.testing.validation.form.user.UserEmailNotActive;
import com.vti.testing.validation.form.user.UserIDExists;
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

		// Sending the Registration Confirm to User's Email
		return sendConfirmRegistrationViaEmail(registeredUser.getEmail());
	}

	@ApiOperation(value = "Send confirm registration via Email")
	@GetMapping("/registrationConfirmRequest")
	public ResponseEntity<?> sendConfirmRegistrationViaEmail(
			@ApiParam(value = "User's email to active registration", required = true) @UserEmailExists @UserEmailNotActive @Param(value = "email") String email) {

		// Resending the Registration Confirm to User's Email
		eventPublisher.publishEvent(new OnSendRegistrationUserConfirmViaEmailEvent(email));

		return new ResponseEntity<>("We have sent 1 email. Please check email to active account!", HttpStatus.OK);
	}

	@ApiOperation(value = "Active User via Email")
	@GetMapping("/activeUser")
	public ResponseEntity<?> activeUserViaEmail(
			@ApiParam(value = "Token to active user", required = true) @RegistrationUserTokenValid @Param(value = "token") String token) {

		// active user
		service.activeUser(token);

		return new ResponseEntity<>("Active success!", HttpStatus.OK);
	}

	@ApiOperation(value = "Reset password via Email")
	@GetMapping("/resetPasswordRequest")
	public ResponseEntity<?> requestResetPasswordViaEmail(
			@ApiParam(value = "User's email to reset password", required = true) @UserEmailExists @Param(value = "email") String email) {

		// sending reset password token to user's email
		eventPublisher.publishEvent(new OnResetPasswordViaEmailEvent(email));

		return new ResponseEntity<>("We have sent 1 email. Please check email to reset account!", HttpStatus.OK);
	}

	@ApiOperation(value = "Reset password via Email")
	@GetMapping("/resetPassword")
	public ResponseEntity<?> resetPasswordViaEmail(
			@ApiParam(value = "Token to reset password", required = true) @ResetPasswordTokenValid @Param(value = "token") String token,
			@ApiParam(value = "new password of user", required = true) @NotEmpty(message = "{UserForm.password.NotEmpty}") @Size(max = 50, message = "{UserForm.password.Size}") @Param(value = "newPassword") String newPassword) {

		// reset password
		service.resetPassword(token, newPassword);

		return new ResponseEntity<>("Reset password success!", HttpStatus.OK);
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
			@ApiParam(value = "User's Id to update UserName object", required = true) @UserIDExists @PathVariable(name = "id") int id,
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
