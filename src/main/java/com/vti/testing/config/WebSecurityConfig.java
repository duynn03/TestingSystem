//
package com.vti.testing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vti.testing.service.UserServiceImpl;

/**
 * This class is configution security in Website.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 17, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 17, 2020
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserServiceImpl service;

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Password encoder, để Spring Security sử dụng mã hóa BCrypt để mã hóa mật khẩu
		// người dùng
		return new BCryptPasswordEncoder();
	}

	/**
	 * This method is Encoder Password.
	 * 
	 * @Description: .
	 * @author: CTANH
	 * @create_date: Mar 17, 2020
	 * @version: 1.0
	 * @modifer: CTANH
	 * @modifer_date: Mar 17, 2020
	 * @return
	 */

	/*
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.authentication.builders.AuthenticationManagerBuilder) configution
	 * Security
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service) // Cung cáp userservice cho spring security
				.passwordEncoder(passwordEncoder()); // cung cấp password encoder
		auth.authenticationProvider(authenticationProvider());
	}

	/*
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors() // Ngăn chặn request từ một domain khác
				.and().authorizeRequests().antMatchers("/oauth/token").permitAll() // Cho phép tất cả mọi người truy cập
																					// vào địa chỉ này
				.anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(service);
		return provider;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

}
