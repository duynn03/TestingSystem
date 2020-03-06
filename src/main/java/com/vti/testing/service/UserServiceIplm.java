package com.vti.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.testing.entity.User;
import com.vti.testing.form.UserForm;
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
public class UserServiceIplm implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public Page<User> getAllUser(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public User getUserByID(short id) {
		return repository.findById(id).get();
	}

	@Override
	public void createUser(UserForm form) {
		repository.save(form.toEntityCreate());

	}

	@Override
	public void updateUser(short id, UserForm form) {
		User user = getUserByID(id);

		// update name
		if (!StringUtils.isEmpty(form.getAccount())) {
			user.setAccount(form.getAccount());
		}

		repository.save(user);

	}

	@Override
	public void deleteUser(short id) {
		repository.deleteById(id);

	}

	@Override
	public boolean existsUser(short id) {
		return repository.existsById(id);
	}

	@Override
	public boolean existsUser(String Account) {
		return repository.existsByAccount(Account);
	}

}
