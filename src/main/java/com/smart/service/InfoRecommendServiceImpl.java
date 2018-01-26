package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.consts.InfoRecommendType;
import com.smart.dao.BaseDao;
import com.smart.dao.InfoRecommendDao;
import com.smart.model.InfoRecommend;
import com.smart.model.InfoRecommendCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class InfoRecommendServiceImpl extends BaseEntityService<InfoRecommend, InfoRecommendCond, Long> implements InfoRecommendService{

	@Autowired
	private InfoRecommendDao dao;
	
	@Override
	protected BaseDao<InfoRecommend, InfoRecommendCond, Long> getDao() {
		return dao;
	}
	
	public boolean recommendExists(InfoRecommendType type, Long infoId) {
		return dao.recommendExists(type, infoId);
	}
	
	
}
