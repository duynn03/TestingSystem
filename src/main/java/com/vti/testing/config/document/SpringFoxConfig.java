package com.vti.testing.config.document;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.vti.testing.config.document.property.EmailAnnotationPlugin;
import com.vti.testing.config.document.property.SearchAnnotationPlugin;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * This class is configuration of SpringFox (Swagger2). 
 * JSON: http://localhost:8080/v2/api-docs UI: http://localhost:8080/swagger-ui.html
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 21, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 21, 2020
 */
@Configuration
@EnableSwagger2WebMvc
@Import({ BeanValidatorPluginsConfiguration.class, SpringDataRestConfiguration.class })
public class SpringFoxConfig {
	
	/**
	 * This method is used for API document Configuration . 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 21, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 21, 2020
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.vti.testing.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	/**
	 * This method is used for API information configuration. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 21, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 21, 2020
	 * @return
	 */
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Testing System API", // title
	      "This is API description for Testing System", // description
	      "1.0", // version
	      "Terms of service", // termsOfServiceUrl
	      new Contact("EDP01 Team", "https://www.facebook.com/VTIAcademy/", "info@vtiacademy.edu.vn"), // contact
	      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html", // license
	      Collections.emptyList()); // vendors
	}

	/**
	 * This method is used for enable document of email property . 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 21, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 21, 2020
	 * @return
	 */
	@Bean
	public EmailAnnotationPlugin emailPlugin() {
		return new EmailAnnotationPlugin();
	}
	
	/**
	 * This method is used for enable document of search parameter . 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 21, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 21, 2020
	 * @return
	 */
	@Bean
	public SearchAnnotationPlugin searchPlugin() {
		return new SearchAnnotationPlugin();
	}
}