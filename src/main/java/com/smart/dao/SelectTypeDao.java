package com.smart.dao;

import com.smart.model.SelectType;
import com.smart.model.SelectTypeCond;

public interface SelectTypeDao extends BaseDao<SelectType, SelectTypeCond, Long>{
	public SelectType findByCode(String code);
}