package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.consts.InfoRecommendType;
import com.smart.model.InfoRecommend;
import com.smart.model.InfoRecommendCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface InfoRecommendService extends BaseService<InfoRecommend, InfoRecommendCond, Long>{
	boolean recommendExists(InfoRecommendType type, Long infoId);
}
