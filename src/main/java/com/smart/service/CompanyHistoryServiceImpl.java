package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.CompanyHistoryDao;
import com.smart.model.CompanyHistory;
import com.smart.model.CompanyHistoryCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class CompanyHistoryServiceImpl extends BaseEntityService<CompanyHistory, CompanyHistoryCond, Long> implements CompanyHistoryService{

	@Autowired
	private CompanyHistoryDao dao;
	
	@Override
	protected BaseDao<CompanyHistory, CompanyHistoryCond, Long> getDao() {
		return dao;
	}
	
	
}
