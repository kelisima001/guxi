package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.{name}Dao;
import com.smart.model.{name};
import com.smart.model.{name}Cond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class {name}ServiceImpl extends BaseEntityService<{name}, {name}Cond, Long> implements {name}Service{

	@Autowired
	private {name}Dao dao;
	
	@Override
	protected BaseDao<{name}, {name}Cond, Long> getDao() {
		return dao;
	}
	
	
}
