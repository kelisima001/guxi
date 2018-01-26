package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.SeoPriceDao;
import com.smart.model.SeoPrice;
import com.smart.model.SeoPriceCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class SeoPriceServiceImpl extends BaseEntityService<SeoPrice, SeoPriceCond, Long> implements SeoPriceService{

	@Autowired
	private SeoPriceDao dao;
	
	@Override
	protected BaseDao<SeoPrice, SeoPriceCond, Long> getDao() {
		return dao;
	}
	
	
}
