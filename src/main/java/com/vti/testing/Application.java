package com.vti.testing;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class Application {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(Application.class, args);
	}

	public static <T> T getBean(Class<T> bean) {
		return context.getBean(bean);
	}

	/**
	 * This method is used for conversion object initiation.
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
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}