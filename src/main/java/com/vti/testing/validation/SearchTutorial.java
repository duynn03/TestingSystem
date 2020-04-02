package com.vti.testing.validation;

import com.vti.testing.Application;
import com.vti.testing.config.internationalization.MessageProperty;
import com.vti.testing.config.resourceproperties.searchparameter.GroupPatternProperty;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 30, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 30, 2020
 */
public class SearchTutorial {
	
	private GroupPatternProperty groupPatternProperty;

	private MessageProperty messageProperty;
	
	/**
	 * Constructor for class SearchTutorial.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Apr 2, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Apr 2, 2020
	 */
	public SearchTutorial() {
		groupPatternProperty = Application.getBean(GroupPatternProperty.class);
		messageProperty  = Application.getBean(MessageProperty.class);
	}

	/**
	 * This method is getted default message from message.properties file.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 30, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 30, 2020
	 * @return
	 */
	public String getTutorialMessage() {
		return    messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.tutorial") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.regexMultipleCondition") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.eachCondition") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.keyGroup") + groupPatternProperty.getKey() + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.keyGroup.example") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.operatorGroup") + groupPatternProperty.getOperator() + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.operatorGroup.example") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.firstWildcardLikeGroup") + groupPatternProperty.getWildcardLike() + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.firstWildcardLikeGroup.example") + "\n" 
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup.extra") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup.alphanumberic") + groupPatternProperty.getAlphanumbericalValue() + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup.alphanumberic.example") + "\n" 
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup.date") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup.date.extra") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup.date.example") + groupPatternProperty.getDateValue() + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup.datetime") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup.datetime.extra") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.valueGroup.datetime.example") + groupPatternProperty.getDateTimeValue() + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.secondWildcardLikeGroup") + groupPatternProperty.getWildcardLike() + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.secondWildcardLikeGroup.example") + "\n" 
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.finalRegex") + groupPatternProperty.getCriteraRegex() + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.onlyCondition") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.onlyCondition.example1") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.onlyCondition.example2") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.multipleCondition") + "\n"
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.multipleCondition.example") + "\n" 
				+ messageProperty.getExceptionMessageFromPropertiesFile("SearchParameter.testing") + "\n";
	}

}
