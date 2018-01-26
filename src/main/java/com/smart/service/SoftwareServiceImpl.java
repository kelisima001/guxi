package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.SoftwareDao;
import com.smart.model.Software;
import com.smart.model.SoftwareCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class SoftwareServiceImpl extends BaseEntityService<Software, SoftwareCond, Long> implements SoftwareService{

	@Autowired
	private SoftwareDao dao;
	
	@Override
	protected BaseDao<Software, SoftwareCond, Long> getDao() {
		return dao;
	}
	
	
}
