package com.vti.testing.config.document.property;

import static springfox.bean.validators.plugins.Validators.annotationFromBean;

import java.util.Optional;

import javax.validation.constraints.Email;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import springfox.bean.validators.plugins.Validators;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

/**
 * This class is email annotation document.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 21, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 21, 2020
 */
@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class EmailAnnotationPlugin implements ModelPropertyBuilderPlugin {

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
	 * springfox.documentation.spi.schema.ModelPropertyBuilderPlugin#apply(springfox
	 * .documentation.spi.schema.contexts.ModelPropertyContext)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void apply(ModelPropertyContext context) {
		Optional<Email> email = annotationFromBean(context, Email.class);
		if (email.isPresent()) {
			context.getBuilder().pattern(email.get().regexp());
			context.getBuilder().example("duy.nguyenngoc1@vti.com.vn");
		}

	}
}