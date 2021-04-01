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
		return    messageProperty.getMessage("SearchParameter.tutorial") + "\n"
				+ messageProperty.getMessage("SearchParameter.regexMultipleCondition") + "\n"
				+ messageProperty.getMessage("SearchParameter.eachCondition") + "\n"
				+ messageProperty.getMessage("SearchParameter.keyGroup") + groupPatternProperty.getKey() + "\n"
				+ messageProperty.getMessage("SearchParameter.keyGroup.example") + "\n"
				+ messageProperty.getMessage("SearchParameter.operatorGroup") + groupPatternProperty.getOperator() + "\n"
				+ messageProperty.getMessage("SearchParameter.operatorGroup.example") + "\n"
				+ messageProperty.getMessage("SearchParameter.firstWildcardLikeGroup") + groupPatternProperty.getWildcardLike() + "\n"
				+ messageProperty.getMessage("SearchParameter.firstWildcardLikeGroup.example") + "\n" 
				+ messageProperty.getMessage("SearchParameter.valueGroup") + "\n"
				+ messageProperty.getMessage("SearchParameter.valueGroup.extra") + "\n"
				+ messageProperty.getMessage("SearchParameter.valueGroup.alphanumberic") + groupPatternProperty.getAlphanumbericalValue() + "\n"
				+ messageProperty.getMessage("SearchParameter.valueGroup.alphanumberic.example") + "\n" 
				+ messageProperty.getMessage("SearchParameter.valueGroup.date") + "\n"
				+ messageProperty.getMessage("SearchParameter.valueGroup.date.extra") + "\n"
				+ messageProperty.getMessage("SearchParameter.valueGroup.date.example") + groupPatternProperty.getDateValue() + "\n"
				+ messageProperty.getMessage("SearchParameter.valueGroup.datetime") + "\n"
				+ messageProperty.getMessage("SearchParameter.valueGroup.datetime.extra") + "\n"
				+ messageProperty.getMessage("SearchParameter.valueGroup.datetime.example") + groupPatternProperty.getDateTimeValue() + "\n"
				+ messageProperty.getMessage("SearchParameter.secondWildcardLikeGroup") + groupPatternProperty.getWildcardLike() + "\n"
				+ messageProperty.getMessage("SearchParameter.secondWildcardLikeGroup.example") + "\n" 
				+ messageProperty.getMessage("SearchParameter.finalRegex") + groupPatternProperty.getCriteraRegex() + "\n"
				+ messageProperty.getMessage("SearchParameter.onlyCondition") + "\n"
				+ messageProperty.getMessage("SearchParameter.onlyCondition.example1") + "\n"
				+ messageProperty.getMessage("SearchParameter.onlyCondition.example2") + "\n"
				+ messageProperty.getMessage("SearchParameter.multipleCondition") + "\n"
				+ messageProperty.getMessage("SearchParameter.multipleCondition.example") + "\n" 
				+ messageProperty.getMessage("SearchParameter.testing") + "\n";
	}

}
