package com.smart.dao;

import org.springframework.stereotype.Repository;

import com.smart.model.SelectType;
import com.smart.model.SelectTypeCond;

@Repository
public class SelectTypeDaoImpl extends BaseEntityDao<SelectType, SelectTypeCond, Long> implements SelectTypeDao {

	@Override
	public SelectType findByCode(String code) {
		return super.findOneBy("code", code);
	}


}
