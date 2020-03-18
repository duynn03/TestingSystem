package com.vti.testing.specification;

public enum SearchOperation {
	EQUALITY, NEGATION, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, LIKE, STARTS_WITH,
	ENDS_WITH, CONTAINS;

	public static final String WILDCARD_LIKE = "*";

	public static final String LINKING_ATTRIBUTE = ".";

	public static final String LINKING_ATTRIBUTE_ENCODE = "\\.";

	public static final String OR_OPERATOR = "OR";

	public static final String AND_OPERATOR = "AND";

	public static final String LEFT_PARANTHESIS = "(";

	public static final String RIGHT_PARANTHESIS = ")";

	// regex
	public static final String KEY_GROUP_PATTERN = "(\\w+.*\\w+)";
	public static final String OPERATOR_GROUP_PATTERN = "(>=|<=|=|!=|>|<|~)";
	// value
	public static final String ALPHANUMBERICAL_VALUE_PATTERN = "\\p{L}+"; // \\p{L}+ support utf-8
	public static final String DATE_VALUE_PATTERN = "\\d{4}\\-\\d{1,2}\\-\\d{1,2}";
	public static final String DATETIME_VALUE_PATTERN = "\\d{4}\\-\\d{1,2}\\-\\d{1,2}T\\d{1,2}\\:\\d{1,2}\\:\\d{1,2}";
	public static final String VALUE_GROUP = "(" + ALPHANUMBERICAL_VALUE_PATTERN + "|" + DATE_VALUE_PATTERN + "|"
			+ DATETIME_VALUE_PATTERN + ")";
	// (\\p{Punct}?)
	public static final String WILDCARD_LIKE_GROUP_PATTERN = "(\\*?)";

	public static SearchOperation getSimpleOperation(final String input) {
		if ("=".equals(input)) {
			return EQUALITY;

		} else if ("!=".equals(input)) {
			return NEGATION;

		} else if (">".equals(input)) {
			return GREATER_THAN;

		} else if (">=".equals(input)) {
			return GREATER_THAN_OR_EQUAL;

		} else if ("<".equals(input)) {
			return LESS_THAN;

		} else if ("<=".equals(input)) {
			return LESS_THAN_OR_EQUAL;

		} else if ("~".equals(input)) {
			return LIKE;

		}
		return null;
	}
}
