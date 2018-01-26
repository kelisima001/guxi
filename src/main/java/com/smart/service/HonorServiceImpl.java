package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.HonorDao;
import com.smart.model.Honor;
import com.smart.model.HonorCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class HonorServiceImpl extends BaseEntityService<Honor, HonorCond, Long> implements HonorService{

	@Autowired
	private HonorDao dao;
	
	@Override
	protected BaseDao<Honor, HonorCond, Long> getDao() {
		return dao;
	}
	
	
}
