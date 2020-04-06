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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.testing.entity.RegistrationUserToken;
import com.vti.testing.entity.ResetPasswordToken;
import com.vti.testing.entity.User;
import com.vti.testing.entity.enumerate.UserStatus;
import com.vti.testing.repository.RegistrationUserTokenRepository;
import com.vti.testing.repository.ResetPasswordTokenRepository;
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
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RegistrationUserTokenRepository registrationUserTokenRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ResetPasswordTokenRepository resetPasswordTokenRepository;

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
	 * @see com.vti.testing.service.UserService#getUserByEmail(java.lang.String)
	 */
	@Override
	public User getUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	/*
	 * @see com.vti.template.service.UserService#createUser( User)
	 */
	@Override
	public User createUser(User entity) {
		// encode password
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return repository.save(entity);
	}

	/*
	 * @see com.vti.testing.service.UserService#createRegistrationUserToken(com.vti.
	 * testing.entity. RegistrationUserToken)
	 */
	@Override
	public void createRegistrationUserToken(RegistrationUserToken token) {
		registrationUserTokenRepository.save(token);
	}

	/*
	 * @see com.vti.testing.service.UserService#getRegistrationUserToken(java.lang.
	 * String)
	 */
	@Override
	public RegistrationUserToken getRegistrationUserToken(String token) {
		return registrationUserTokenRepository.findByToken(token);
	}

	/*
	 * @see
	 * com.vti.testing.service.UserService#isRegistrationUserTokenValid(java.lang.
	 * String)
	 */
	@Override
	public boolean isRegistrationUserTokenValid(String token) {
		RegistrationUserToken entity = getRegistrationUserToken(token);

		if (entity == null || entity.isExpiryDate()) {
			return false;
		}

		return true;
	}

	/*
	 * @see com.vti.testing.service.UserService#activeUser(java.lang.String)
	 */
	@Override
	public void activeUser(String token) {
		// get token
		RegistrationUserToken registrationToken = getRegistrationUserToken(token);

		// active user
		User user = registrationToken.getUser();
		user.setStatus(UserStatus.ACTIVE);
		updateUser(user);

		// delete token
		deleteRegistrationUserToken(registrationToken.getId());
	}

	/**
	 * This method is used for deleting token.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param id
	 */
	private void deleteRegistrationUserToken(int id) {
		registrationUserTokenRepository.deleteById(id);
	}

	/*
	 * @see
	 * com.vti.testing.service.UserService#deleteRegistrationUserTokenByUserId(int)
	 */
	@Override
	public void deleteRegistrationUserTokenByUserId(int userId) {
		registrationUserTokenRepository.deleteByUserId(userId);
	}

	/*
	 * @see
	 * com.vti.testing.service.UserService#createResetPasswordToken(com.vti.testing.
	 * entity.ResetPasswordToken)
	 */
	@Override
	public void createResetPasswordToken(ResetPasswordToken token) {
		resetPasswordTokenRepository.save(token);
	}

	/*
	 * @see
	 * com.vti.testing.service.UserService#getResetPasswordToken(java.lang.String)
	 */
	@Override
	public ResetPasswordToken getResetPasswordToken(String token) {
		return resetPasswordTokenRepository.findByToken(token);
	}

	/*
	 * @see com.vti.testing.service.UserService#isResetPasswordTokenValid(java.lang.
	 * String)
	 */
	@Override
	public boolean isResetPasswordTokenValid(String token) {
		ResetPasswordToken entity = getResetPasswordToken(token);

		if (entity == null || entity.isExpiryDate()) {
			return false;
		}

		return true;
	}

	/*
	 * @see
	 * com.vti.testing.service.UserService#deleteResetPasswordTokenByUserId(int)
	 */
	@Override
	public void deleteResetPasswordTokenByUserId(int userId) {
		resetPasswordTokenRepository.deleteByUserId(userId);
	}

	/*
	 * @see com.vti.testing.service.UserService#resetPassword(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void resetPassword(String token, String newPassword) {

		// get token
		ResetPasswordToken resetPasswordToken = getResetPasswordToken(token);

		// change password
		User user = resetPasswordToken.getUser();
		user.setPassword(passwordEncoder.encode(newPassword));
		updateUser(user);

		// delete token
		deleteResetPasswordToken(resetPasswordToken.getId());
	}

	/**
	 * This method is used for deleting token.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 5, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 5, 2020
	 * @param id
	 */
	private void deleteResetPasswordToken(int id) {
		resetPasswordTokenRepository.deleteById(id);
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
		return repository.existsById(id);
	}

	/*
	 * @see com.vti.testing.service.UserService#existsByUserName(java.lang.String)
	 */
	@Override
	public boolean existsByUserName(String userName) {
		return repository.existsByUserName(userName);
	}

	/*
	 * @see com.vti.testing.service.UserService#existsByEmail(java.lang.String)
	 */
	@Override
	public boolean existsByEmail(String email) {
		return repository.existsByEmail(email);
	}

	/*
	 * @see com.vti.testing.service.UserService#isEmailActive(java.lang.String)
	 */
	@Override
	public boolean isEmailActive(String email) {

		// get user's status by email
		UserStatus status = repository.findStatusByEmail(email);

		if (null == status) {
			return false;
		}

		return status != UserStatus.NOT_ACTIVE;
	}

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
	}
}
