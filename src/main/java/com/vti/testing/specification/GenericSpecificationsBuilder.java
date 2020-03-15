package com.vti.testing.specification;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.domain.Specification;

/**
 * This class is generic of Specification Builder.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 12, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 12, 2020
 * @param <T>
 */
public class GenericSpecificationsBuilder<T> {

	/**
	 * This method is converted to Specification.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 13, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 13, 2020
	 * @param criteriaExpressionStack
	 * @param converter
	 * @return
	 */
	public Specification<T> build(Deque<?> criteriaExpressionStack,
			Function<SearchCriteria, Specification<T>> converter) {

		Deque<Specification<T>> specificationStack = new LinkedList<>();

		Collections.reverse((List<?>) criteriaExpressionStack);

		while (!criteriaExpressionStack.isEmpty()) {
			Object mayBeOperand = criteriaExpressionStack.pop();

			if (!(mayBeOperand instanceof String)) {
				specificationStack.push(converter.apply((SearchCriteria) mayBeOperand));

			} else {
				Specification<T> operand1 = specificationStack.pop();
				Specification<T> operand2 = specificationStack.pop();
				if (mayBeOperand.equals(SearchOperation.AND_OPERATOR))
					specificationStack.push(Specification.where(operand1).and(operand2));

				else if (mayBeOperand.equals(SearchOperation.OR_OPERATOR))
					specificationStack.push(Specification.where(operand1).or(operand2));
			}

		}

		return specificationStack.pop();
	}

}
