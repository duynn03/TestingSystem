package com.vti.testing.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.vti.testing.specification.CriteriaParser;
import com.vti.testing.specification.SearchOperation;

/**
 * This interface is a annotation bean validation.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Feb 8, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Feb 8, 2020
 */
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { SearchValidator.class })
public @interface Search {

	String message() default "";
//	"The Search Parameter isn't matching with regex search!" +"\n"
//			+ "Totorial:" +"\n"
//			+ "	Regex search maybe include multiple contidion and which can combine together." +"\n"
//			+ "	Each condition include 5 group:" +"\n"
//			+"		1.	Regex for Key:" + SearchOperation.KEY_GROUP_PATTERN +"\n"
//			+ "			Example: id, name, author.id, testingCategory.author.id" +"\n"
//			+"		2.	Regex for Operator:" + SearchOperation.OPERATOR_GROUP_PATTERN +"\n"
//			+ "	 		Example: id, name, author.id, testingCategory.author.id" +"\n"
//			+"		3.	Regex for Wildcard Like (optional):" + SearchOperation.WILDCARD_LIKE_GROUP_PATTERN +"\n"
//			+ "			Example: *" +"\n"
//			+"		4.	Regex for Value:" +"\n"
//			+ "			(Value maybe alphanumberic or date or datetime)" +"\n"
//			+"			4.1.Regex for Alphanumberic:"+ SearchOperation.ALPHANUMBERICAL_VALUE_PATTERN +"\n"
//			+ "				Example: 5, duy" +"\n"
//			+"			4.2.Regex for Date:"+ SearchOperation.DATE_VALUE_PATTERN +"\n"
//			+ "				Format: YYYY-MM-DD" +"\n"
//			+ "				Example: 2020-03-14" +"\n"
//			+"			4.3.Regex for DateTime:"+ SearchOperation.DATETIME_VALUE_PATTERN +"\n"
//			+ "				Format: YYYY-MM-DD'T'HH:MM:SS" +"\n"
//			+ "				Example: 2020-03-14T17:30:20" +"\n"
//			+"		5.	Regex for Wildcard Like (optional):" + SearchOperation.WILDCARD_LIKE_GROUP_PATTERN +"\n"
//			+ "			Example: *" +"\n"
//			+ "	Finnaly, Regex for entire search parameter:" + CriteriaParser.CRITERIA_REGEX +"\n"
//			+ "	Example: only condition" +"\n"
//			+ "			 createTime>=2020-03-14" +"\n"
//			+ "			 id>5" +"\n"
//			+ "	Example: multiple condition" +"\n"
//			+ "			 ( createTime>=2020-03-14 OR id>5 ) AND author.id>3" +"\n"
//			+ "Testing search parameter: https://regexr.com/";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}