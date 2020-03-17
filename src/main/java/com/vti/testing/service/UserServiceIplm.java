package com.vti.testing.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vti.testing.entity.Users;
import com.vti.testing.repository.UserRepository;

/**
 * This class is UserServiceIplm.
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Mar 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Mar 6, 2020
 */
@Service
public class UserServiceIplm implements  UserDetailsService {

	@Autowired
	private UserRepository repository;

//	@Override
//	public Page<Users> getAllUser(Pageable pageable) {
//		return repository.findAll(pageable);
//	}
//
//	@Override
//	public Users getUserByID(short id) {
//		return repository.findById(id).get();
//	}

//	@Override
//	public void createUser(UserForm form) {
//		repository.save(form.toEntityCreate());
//
//	}
//
//	@Override
//	public void updateUser(short id, UserForm form) {
//		User user = getUserByID(id);
//
//		// update name
//		if (!StringUtils.isEmpty(form.getAccount())) {
//			user.setAccount(form.getAccount());
//		}
//
//		repository.save(user);
//
//	}

//	@Override
//	public void deleteUser(short id) {
//		repository.deleteById(id);
//
//	}
//
//	@Override
//	public boolean existsUser(short id) {
//		return repository.existsById(id);
//	}
//
//	@Override
//	public boolean existsUser(String Account) {
//		return repository.existsByAccount(Account);
//	}

	/*
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String) coder: CTAnh
	 * 
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Kiểm tra xem user có tồn tại trong database không?
		Users user = repository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+user.getRole());
		return new User(user.getUserName(), user.getPassword(),
				Arrays.asList(authority));
	}

	/* 
	* @see com.vti.testing.service.UserService#createUser(com.vti.testing.form.UserForm)
	*/
//	@Override
//	public void createUser(UserForm form) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	/* 
//	* @see com.vti.testing.service.UserService#updateUser(short, com.vti.testing.form.UserForm)
//	*/
//	@Override
//	public void updateUser(short id, UserForm form) {
//		// TODO Auto-generated method stub
//		
//	}

}
