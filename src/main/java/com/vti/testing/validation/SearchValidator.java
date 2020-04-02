package com.vti.testing.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.vti.testing.Application;
import com.vti.testing.config.internationalization.MessageProperty;
import com.vti.testing.config.resourceproperties.searchparameter.GroupPatternProperty;
import com.vti.testing.config.resourceproperties.searchparameter.OperatorProperty;
import com.vti.testing.specification.CriteriaParser;
import com.vti.testing.utils.MethodUtil;

/**
 * This class is implement logic of annotation bean validation.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 14, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 14, 2020
 */
public class SearchValidator implements ConstraintValidator<Search, String> {

	private GroupPatternProperty groupPatternProperty;

	private OperatorProperty operatorProperty;

	private MessageProperty messageProperty;

	private String message;

	/*
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(Search constraintAnnotation) {
		groupPatternProperty = Application.getBean(GroupPatternProperty.class);
		operatorProperty = Application.getBean(OperatorProperty.class);
		messageProperty = Application.getBean(MessageProperty.class);
	}

	/*
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String data, ConstraintValidatorContext context) {
		// null values are valid
		if (StringUtils.isEmpty(data)) {
			return true;
		}

		String[] tokens = data.split("\\s+");
		for (String token : tokens) {
			if (!CriteriaParser.OPERATORS.containsKey(token) && !token.equals(operatorProperty.getLeftParanthesis())
					&& !token.equals(operatorProperty.getRightParanthesis())) {
				if (!MethodUtil.checkRegularExpression(token, groupPatternProperty.getCriteraRegex())) {
					addTokenNotMatchingToDefaultMessage(context, token);
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * This method is added token not matching to default message.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 19, 2020
	 * @param context
	 */
	private void addTokenNotMatchingToDefaultMessage(ConstraintValidatorContext context, String token) {

		message = messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.couldNotParseRegex") + token;

		// disable existing violation message
		context.disableDefaultConstraintViolation();
		// build new violation message and add it
		context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
	}

}