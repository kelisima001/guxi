package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.SelectType;
import com.smart.model.SelectTypeCond;

@Transactional(readOnly=true)
public interface SelectTypeService extends BaseService<SelectType, SelectTypeCond, Long>{
	public SelectType findByCode(String code);
}
