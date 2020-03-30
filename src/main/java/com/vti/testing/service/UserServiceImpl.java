package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.testing.entity.User;
import com.vti.testing.repository.UserRepository;

/**
 * This class is implement User Service.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	/*
	 * @see com.vti.template.service.UserService#getAllUsers()
	 */
	@Override
	public Page<User> getAllUsers(Specification<User> specification, Pageable pageable) {
		return repository.findAll(specification, pageable);
	}

	/*
	 * @see com.vti.template.service.UserService#getUserByID( short)
	 */
	@Override
	public User getUserByID(int id) {
		return repository.findById(id).get();
	}

	/*
	 * @see com.vti.template.service.UserService#createUser( User)
	 */
	@Override
	public void createUser(User entity) {
		repository.save(entity);
	}

	/*
	 * @see com.vti.template.service.UserService#updateUser( User)
	 */
	@Override
	public void updateUser(User entity) {
		repository.save(entity);
	}

	/*
	 * @see com.vti.template.service.UserService#deleteUser( short)
	 */
	@Override
	public void deleteUser(int id) {
		repository.deleteById(id);
	}

	/*
	 * @see com.vti.template.service.UserService#existsUser( short)
	 */
	@Override
	public boolean existsUser(int id) {
		return repository.existsById(id);
	}

	@Override
	public boolean existsByUserName(String userName) {
		return repository.existsByUserName(userName);
	}
}
