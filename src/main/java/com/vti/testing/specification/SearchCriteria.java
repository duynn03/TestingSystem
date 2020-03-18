package com.vti.testing.specification;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.vti.testing.utils.MethodUtil;

/**
 * This class is search criteria.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 12, 2020
 */
public class SearchCriteria {

	// Ex: Category.Account.id to List key
	private List<String> keys;
	private SearchOperation operation;
	private Object value;

	/**
	 * Constructor for class SearchCriteria.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 12, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 12, 2020
	 * @param key
	 * @param operation
	 * @param prefix
	 * @param value
	 * @param suffix
	 * @throws ParseException
	 */
	public SearchCriteria(String key, String operation, String prefix, String value, String suffix)
			throws ParseException {
		this.operation = convertStringToSearchOperationObject(operation, prefix, suffix);
		parseKey(key);
		parseValue(value);
	}

	/**
	 * This method is converted string to SearchOperation Object.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 12, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 12, 2020
	 * @param operation
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public static SearchOperation convertStringToSearchOperationObject(String operation, String prefix, String suffix) {
		// convert operator from String to SearchOperation Object
		SearchOperation op = SearchOperation.getSimpleOperation(operation);
		if (op != null && op == SearchOperation.EQUALITY) { // the operation may be complex operation
			final boolean isStartWithAsterisk;
			if (!StringUtils.isEmpty(prefix) && prefix.contains(SearchOperation.WILDCARD_LIKE)) {
				isStartWithAsterisk = true;
			} else {
				isStartWithAsterisk = false;
			}

			final boolean isEndWithAsterisk;
			if (!StringUtils.isEmpty(suffix) && suffix.contains(SearchOperation.WILDCARD_LIKE)) {
				isEndWithAsterisk = true;
			} else {
				isEndWithAsterisk = false;
			}

			if (isStartWithAsterisk && isEndWithAsterisk) {
				op = SearchOperation.CONTAINS;
			} else if (isStartWithAsterisk) {
				op = SearchOperation.ENDS_WITH;
			} else if (isEndWithAsterisk) {
				op = SearchOperation.STARTS_WITH;
			}
		}
		return op;
	}

	/**
	 * This method is parsed key String to List.
	 * 
	 * @Description: convert Category.Account.id to List key.
	 * @author: NNDuy
	 * @create_date: Mar 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 13, 2020
	 * @param key
	 */
	private void parseKey(String key) {
		if (key.contains(SearchOperation.LINKING_ATTRIBUTE)) {
			this.keys = Arrays.stream(key.split(SearchOperation.LINKING_ATTRIBUTE_ENCODE)).collect(Collectors.toList());
		} else {
			this.keys = new ArrayList<>();
			this.keys.add(key);
		}
	}

	/**
	 * This method is parsed value (value maybe alphanumberic or date)
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 14, 2020
	 * @param value
	 * @throws ParseException
	 */
	public void parseValue(String value) throws ParseException {
		if (MethodUtil.checkRegularExpression(value, SearchOperation.DATETIME_VALUE_PATTERN)) {
			this.value = MethodUtil.convertStringToDateTime(value);
		} else if (MethodUtil.checkRegularExpression(value, SearchOperation.DATE_VALUE_PATTERN)) {
			Date date = MethodUtil.convertStringToDate(value);
			switch (operation) {
			case GREATER_THAN:
			case LESS_THAN_OR_EQUAL:
				this.value = getLastTimeOfDay(date);
				break;
			case LESS_THAN:
			case GREATER_THAN_OR_EQUAL:
				this.value = getFirstTimeOfDay(date);
				break;
			default:
				this.value = date;
				break;
			}
		} else {
			this.value = value;
		}
	}

	@SuppressWarnings("deprecation")
	private Date getFirstTimeOfDay(Date date) {
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		return date;
	}

	/**
	 * This method is get the last moment of Day.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 14, 2020
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private Date getLastTimeOfDay(Date date) {
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		return date;
	}

	/**
	 * @return the keys
	 */
	public List<String> getKeys() {
		return keys;
	}

	/**
	 * @return the operation
	 */
	public SearchOperation getOperation() {
		return operation;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

}