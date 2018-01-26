package com.smart.dao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.smart.dao.annotation.Expression;

public class CondAnnotationParser {
	public static void parse(Expression exp, Object val, Criteria crit) {
		String operator = exp.operator().trim();
		String prop = exp.property().trim();
		switch(operator){
			case ">=": {
				crit.add(Restrictions.ge(prop, val));
				break;
			}
			case ">": {
				crit.add(Restrictions.gt(prop, val));
				break;
			}
			case "<": {
				crit.add(Restrictions.lt(prop, val));
				break;
			}
			case "<=": {
				crit.add(Restrictions.le(prop, val));
				break;
			}
			case "in": {
				crit.add(Restrictions.in(prop, (Collection<?>)val));
				break;
			}
			case "like": {
				crit.add(Restrictions.like(prop, val));
				break;
			}
			case "ilike": {
				crit.add(Restrictions.ilike(prop, val));
				break;
			}
			default: {
				crit.add(Restrictions.eq(prop, val));
				break;
			}
			
		}
	}
}
