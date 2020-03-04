package com.vti.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.testing.entity.User;

/**
 * This class is Testing Category repository.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public interface AccountRepository extends JpaRepository<User, Short> {

}
