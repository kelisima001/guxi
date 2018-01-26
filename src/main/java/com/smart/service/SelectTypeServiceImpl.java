package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.SelectTypeDao;
import com.smart.model.SelectType;
import com.smart.model.SelectTypeCond;

@Service
public class SelectTypeServiceImpl extends BaseEntityService<SelectType, SelectTypeCond, Long> implements SelectTypeService{

	@Autowired
	private SelectTypeDao dao;
	
	@Override
	protected BaseDao<SelectType, SelectTypeCond, Long> getDao() {
		return dao;
	}

	@Override
	public SelectType findByCode(String code) {
		return dao.findByCode(code);
	}

}
