package com.vti.testing.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vti.testing.entity.User;
import com.vti.testing.entity.enumerate.UserStatus;
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
public class UserServiceImpl implements UserService, UserDetailsService {

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

		// get current user by id
		User user = getUserByID(id);

		// update status to block
		user.setStatus(UserStatus.BLOCK);

		// save user
		updateUser(user);

	}

	/*
	 * @see com.vti.template.service.UserService#existsUser( short)
	 */
	@Override
	public boolean existsUser(int id) {
		return repository.existsByIdAndStatus(id, UserStatus.ACTIVE);
	}

	@Override
	public boolean existsByUserName(String userName) {
		return repository.existsByUserName(userName);
	}

<<<<<<< HEAD
	@Override
	public boolean existsByEmail(String email) {
		return repository.existsByEmail(email);
=======
	/*
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Kiểm tra xem user có tồn tại trong database không?
		User user = repository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole().toString());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				Arrays.asList(authority));
>>>>>>> develop
	}
}
