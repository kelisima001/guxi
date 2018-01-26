package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.InjectInfoDao;
import com.smart.model.InjectInfo;
import com.smart.model.InjectInfoCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class InjectInfoServiceImpl extends BaseEntityService<InjectInfo, InjectInfoCond, Long> implements InjectInfoService{

	@Autowired
	private InjectInfoDao dao;
	
	@Override
	protected BaseDao<InjectInfo, InjectInfoCond, Long> getDao() {
		return dao;
	}
	
	
}
