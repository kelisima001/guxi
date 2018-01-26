package com.smart.dao;

import com.smart.consts.InfoRecommendType;
import com.smart.model.InfoRecommend;
import com.smart.model.InfoRecommendCond;

/**
 * 
 * @author Sunxin
 *
 */
public interface InfoRecommendDao extends BaseDao<InfoRecommend, InfoRecommendCond, Long>{

	boolean recommendExists(InfoRecommendType type, Long infoId); 
	
}
