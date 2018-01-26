package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.InfoDao;
import com.smart.model.Info;
import com.smart.model.InfoCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class InfoServiceImpl extends BaseEntityService<Info, InfoCond, Long> implements InfoService{

	@Autowired
	private InfoDao dao;
	
	@Override
	protected BaseDao<Info, InfoCond, Long> getDao() {
		return dao;
	}
	
}
