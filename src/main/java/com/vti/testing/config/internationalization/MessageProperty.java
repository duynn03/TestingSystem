package com.vti.testing.config.internationalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * This class is used for getting message from properties file.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 22, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 22, 2020
 */
@Component
@Scope("prototype")
public class MessageProperty {

	@Autowired
	private MessageSource messageSource;

	/**
	 * This method is getted exception message from properties file.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 22, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 22, 2020
	 * @param key
	 */
	public String getExceptionMessageFromPropertiesFile(String key) {
		return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}
}
