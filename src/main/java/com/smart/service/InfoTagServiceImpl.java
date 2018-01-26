package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.InfoTagDao;
import com.smart.model.InfoTag;
import com.smart.model.InfoTagCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class InfoTagServiceImpl extends BaseEntityService<InfoTag, InfoTagCond, Long> implements InfoTagService{

	@Autowired
	private InfoTagDao dao;
	
	@Override
	protected BaseDao<InfoTag, InfoTagCond, Long> getDao() {
		return dao;
	}
	
	
}
