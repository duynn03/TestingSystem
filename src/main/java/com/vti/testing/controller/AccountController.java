package com.vti.testing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/accounts")
@PostAuthorize("hasRole('ADMIN')")
public class AccountController {
//	@Autowired
//	private UserService service;

	@GetMapping()
	public ResponseEntity<?> createAccount() {
		return new ResponseEntity<>("Ngon", HttpStatus.OK);
	}
	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Mar 5, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Mar 5, 2020
	 * @return
	 */

//	@GetMapping()
//	public ResponseEntity<Page<?>> getAllUser(@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults({
//			@SortDefault(sort = "id", direction = Sort.Direction.ASC) }) Pageable pageable) {
//		Page<User> user = service.getAllUser(pageable);
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}

	/**
	 * This method is got Account by ID.
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
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") short id) {
//		User user = service.getUserByID(id);
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}
//
//	/**
//	 * This method is created Account.
//	 * 
//	 * @Description: .
//	 * @author: NNDuy
//	 * @create_date: Dec 7, 2019
//	 * @version: 1.0
//	 * @modifer: NNDuy
//	 * @modifer_date: Dec 7, 2019
//	 * @param form
//	 */
//	@PostMapping()
//	public ResponseEntity<?> createAccount(@RequestBody UserForm form) {
//		service.createUser(form);
//		return new ResponseEntity<>("Create success!", HttpStatus.OK);
//	}
//
//	/**
//	 * This method is updated Account.
//	 * 
//	 * @Description: .
//	 * @author: NNDuy
//	 * @create_date: Dec 13, 2019
//	 * @version: 1.0
//	 * @modifer: NNDuy
//	 * @modifer_date: Dec 13, 2019
//	 * @param form
//	 */
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<?> updateAccount(@PathVariable(name = "id") short id, @RequestBody UserForm form) {
//		service.updateUser(id, form);
//		return new ResponseEntity<>("Update success!", HttpStatus.OK);
//	}
//
//	/**
//	 * This method is deleted Account.
//	 * 
//	 * @Description: .
//	 * @author: NNDuy
//	 * @create_date: Dec 13, 2019
//	 * @version: 1.0
//	 * @modifer: NNDuy
//	 * @modifer_date: Dec 13, 2019
//	 * @param id
//	 */
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
//		service.deleteUser(id);
//		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
//	}

}
