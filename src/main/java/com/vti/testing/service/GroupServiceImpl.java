//
package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.testing.entity.Group;
import com.vti.testing.repository.GroupRepository;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NATOAN
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NAToan
 * @modifer_date: Mar 12, 2020
 */
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository repository;

	/*
	 * @see
	 * com.vti.testing.service.GroupService#getAllGroup(org.springframework.data.
	 * domain.Pageable)
	 */
	@Override
	public Page<Group> getAllGroup(Specification<Group> specification, Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Group getGroupByID(int id) {
		return repository.findById(id).get();

	}

	/*
	 * @see com.vti.testing.service.GroupService#existsGroup(int)
	 */
	@Override
	public boolean existsGroup(int id) {
		return repository.existsById(id);
	}

	/*
	 * @see com.vti.testing.service.GroupService#existsGroup(java.lang.String)
	 */
	@Override
	public boolean existsGroup(String name) {
		return repository.existsByName(name);
	}
}
