//
package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	* @see com.vti.testing.service.GroupService#getAllGroup(org.springframework.data.domain.Pageable)
	*/
	@Override
	public Page<Group> getAllGroup(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
