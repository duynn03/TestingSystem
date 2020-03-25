//
package com.vti.testing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.testing.entity.Group;

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
public interface GroupService {
/**
 * This method is . 
 * 
 * @Description: .
 * @author: NAToan
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NAToan
 * @modifer_date: Mar 12, 2020
 * @param pageable
 * @return
 */
public Page<Group> getAllGroup(Pageable pageable);

}
