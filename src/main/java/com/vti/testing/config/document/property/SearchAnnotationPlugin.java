package com.vti.testing.config.document.property;

import java.util.Optional;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vti.testing.validation.Search;
import com.vti.testing.validation.SearchTutorial;

import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

/**
 * This class is search annotation document.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 21, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 21, 2020
 */
@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1000)
public class SearchAnnotationPlugin implements ParameterBuilderPlugin {

	/*
	 * @see org.springframework.plugin.core.Plugin#supports(java.lang.Object)
	 */
	@Override
	public boolean supports(DocumentationType delimiter) {
		// allow any documentation type like Swagger 1.2 and Swagger 2.
		return true;
	}

	/*
	 * @see
	 * springfox.documentation.spi.service.ParameterBuilderPlugin#apply(springfox.
	 * documentation.spi.service.contexts.ParameterContext)
	 */
	@Override
	public void apply(ParameterContext parameterContext) {
		ResolvedMethodParameter methodParameter = parameterContext.resolvedMethodParameter();
		Optional<Search> searchParam = methodParameter.findAnnotation(Search.class);
		if (searchParam.isPresent()) {
			parameterContext.parameterBuilder().description(/* new SearchTutorial().getTutorialMessage() */"TODO");
		}

	}
}