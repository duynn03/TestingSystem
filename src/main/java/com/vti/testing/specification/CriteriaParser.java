package com.vti.testing.specification;

import java.text.ParseException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ImmutableMap;

/**
 * This class is used for parsing criteria from search String.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 12, 2020
 */
public class CriteriaParser {

	private static final Map<String, Operator> operatorMaps = ImmutableMap.of("AND", Operator.AND, "OR", Operator.OR,
			"or", Operator.OR, "and", Operator.AND);

	private Map<String, Operator> operators;

	private final Pattern criteriaRegex;

	private enum Operator {
		OR(1), AND(2);

		final int priority;

		Operator(int priority) {
			this.priority = priority;
		}
	}

	public static final String CRITERIA_REGEX = "^" + SearchOperation.KEY_GROUP_PATTERN
			+ SearchOperation.OPERATOR_GROUP_PATTERN + SearchOperation.WILDCARD_LIKE_GROUP_PATTERN
			+ SearchOperation.VALUE_GROUP + SearchOperation.WILDCARD_LIKE_GROUP_PATTERN + "$";

	/**
	 * Constructor for class CriteriaParser.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 13, 2020
	 */
	public CriteriaParser() {
		operators = Collections.unmodifiableMap(operatorMaps);
		criteriaRegex = Pattern.compile(CRITERIA_REGEX);
	}

	/**
	 * This method is checked priority of operator.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 13, 2020
	 * @param currentOperator
	 * @param prevOperator
	 * @return
	 */
	private boolean isHigerPriorityOperator(String currentOperator, String prevOperator) {
		return (operators.containsKey(prevOperator)
				&& operators.get(prevOperator).priority >= operators.get(currentOperator).priority);
	}

	/**
	 * This method is used for parsing criteria and operator (AND or OR).
	 * 
	 * @Description: split into tokens (criteria, parenthesis, AND & OR operators).
	 * @author: NNDuy
	 * @create_date: Mar 12, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 12, 2020
	 * @param search
	 * @return
	 */
	public Deque<?> parseToCriteria(String search) throws ParseException {

		Deque<Object> output = new LinkedList<>();
		Deque<String> stack = new LinkedList<>();

		// \\s - matches single whitespace character.
		// \\s+ - matches sequence of one or more whitespace characters
		String[] tokens = search.split("\\s+");
		for (String token : tokens) {
			if (operators.containsKey(token)) {
				while (!stack.isEmpty() && isHigerPriorityOperator(token, stack.peek()))
					output.push(stack.pop().equalsIgnoreCase(SearchOperation.OR_OPERATOR) ? SearchOperation.OR_OPERATOR
							: SearchOperation.AND_OPERATOR);
				stack.push(token.equalsIgnoreCase(SearchOperation.OR_OPERATOR) ? SearchOperation.OR_OPERATOR
						: SearchOperation.AND_OPERATOR);

			} else if (token.equals(SearchOperation.LEFT_PARANTHESIS)) {
				stack.push(SearchOperation.LEFT_PARANTHESIS);

			} else if (token.equals(SearchOperation.RIGHT_PARANTHESIS)) {
				while (!stack.peek().equals(SearchOperation.LEFT_PARANTHESIS))
					output.push(stack.pop());
				stack.pop();

			} else {
				Matcher matcher = criteriaRegex.matcher(token);
				while (matcher.find()) {
					output.push(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3),
							matcher.group(4), matcher.group(5)));
				}
			}
		}

		while (!stack.isEmpty())
			output.push(stack.pop());

		return output;
	}

}
