package com.vti.testing.customUser;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * This class is get Principal in SecurityContextHolder.
 * 
 * @Description: .
 * @author: CTANH
 * @create_date: Mar 24, 2020
 * @version: 1.0
 * @modifer: CTANH
 * @modifer_date: Mar 24, 2020
 */
public class Principal {
	public static String getRole() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String role = ((UserDetails) principal).getAuthorities().toString();
		return role;
	}

	public static boolean getRoleManager() {
		return Principal.getRole().equals("[ROLE_MANAGER]");
	}

}
