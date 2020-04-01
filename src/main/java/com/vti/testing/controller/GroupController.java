package com.vti.testing.controller;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.testing.dto.group.GroupDto;
import com.vti.testing.entity.Group;
import com.vti.testing.service.GroupService;
import com.vti.testing.specification.SpecificationTemplate;
import com.vti.testing.validation.Search;
import com.vti.testing.validation.form.group.GroupIDExists;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Group Management", description = "Including API to manipulate Group")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/groups")
@Validated
public class GroupController {
	@Autowired
	private GroupService service;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * This method is got all Group.
	 * 
	 * @Description: .
	 * @author: NAToan
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NAToan
	 * @modifer_date: Dec 7, 2019
	 * @return List<Group>
	 */
	@ApiOperation(value = "View a list of available Group", response = Page.class)
	@GetMapping()
	public ResponseEntity<Page<?>> getAllGroups(Pageable pageable, @Search String search) throws ParseException {

		// filter
		Specification<Group> specification = SpecificationTemplate.buildSpecification(search);

		// get page entity
		Page<Group> entityPage = service.getAllGroup(specification,   pageable);

		// Convert entity to dto
		Page<GroupDto> dtoPage = convertEntityPageToDtoPage(entityPage, pageable);

		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	private Page<GroupDto> convertEntityPageToDtoPage(Page<Group> entityPage, Pageable pageable) {
		// get list TestingCategory
		List<Group> entities = entityPage.getContent();

		// create conversion type
		Type listType = new TypeToken<List<GroupDto>>() {
		}.getType();

		// convert list entities to dtos
		List<GroupDto> dtos = modelMapper.map(entities, listType);

		// return page dto
		return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
	}

	/**
	 * This method is got Group by ID.
	 * 
	 * @Description: .
	 * @author: NAToan
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NAToan
	 * @modifer_date: Dec 7, 2019
	 * @param id
	 * @return Group
	 */
	@ApiOperation(value = "Get a Group By ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getGroupByID(
			@ApiParam(value = "Group's id from which Group object will retrieve") @GroupIDExists @PathVariable(name = "id") int id) {
		// get entity
		Group entity = service.getGroupByID(id);

		// convert entity to dto
		GroupDto dto = modelMapper.map(entity, GroupDto.class);

		// return result
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}


	/**
	 * This method is created Group.
	 * 
	 * @Description: .
	 * @author: NAToan
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NAToan
	 * @modifer_date: Dec 7, 2019
	 * @param form
	 */
	@PostMapping()
	public ResponseEntity<?> createGroup() {
		return new ResponseEntity<>("Create success!", HttpStatus.OK);
	}

	/**
	 * This method is updated Group.
	 * 
	 * @Description: .
	 * @author: NAToan
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: NAToan
	 * @modifer_date: Dec 13, 2019
	 * @param form
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateGroup() {

		return new ResponseEntity<>("Update success!", HttpStatus.OK);
	}

	/**
	 * This method is deleted Group.
	 * 
	 * @Description: .
	 * @author: NAToan
	 * @create_date: Dec 13, 2019
	 * @version: 1.0
	 * @modifer: NAToan
	 * @modifer_date: Dec 13, 2019
	 * @param id
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGroup() {

		return new ResponseEntity<>("Delete success!", HttpStatus.OK);
	}

}
