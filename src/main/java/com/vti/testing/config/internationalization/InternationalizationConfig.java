package com.vti.testing.config.internationalization;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * This class is Internationalization Configuration.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 22, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 22, 2020
 */
@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {

	/**
	 * This method is used for name properties file configuration.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 22, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 22, 2020
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		// set name messsages_XX.properties file
		messageSource.setBasename("classpath:messages");

		// set utf-8 for messsages_vi.properties
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	/*
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#
	 * getValidator()
	 */
	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		// register the messageSource
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	/**
	 * This method is used for internationalization.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 22, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 22, 2020
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("vi", "VN"));
		return resolver;
	}

	/**
	 * This method is added an interceptor bean that will switch to a new locale
	 * based on the value of the lang parameter appended to a request:.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 22, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 22, 2020
	 * @return
	 */
	@Bean
	public LocaleChangeInterceptor changeLocaleInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	/**
	 * This method is registered interceptor.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 22, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 22, 2020
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(changeLocaleInterceptor());
	}
}
