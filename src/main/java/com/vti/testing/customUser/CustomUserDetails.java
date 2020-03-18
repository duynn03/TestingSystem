//
package com.vti.testing.customUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vti.testing.entity.User;

/**
 * This class is Customize Class UserDetail.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 17, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 17, 2020
 */
public class CustomUserDetails implements UserDetails {
	//
	private static final long serialVersionUID = 1L;
	User user;

	/*
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
		return authorities;
	}

	/**
	 * Constructor for class CustomUserDetails.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 17, 2020
	 * @param user
	 */
	public CustomUserDetails(User user) {
		this.user = user;
	}

	/*
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	/*
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return user.getUserName();
	}

	/*
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired
	 * ()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/*
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked(
	 * )
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/*
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/*
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
