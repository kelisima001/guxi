package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.UserInfoDao;
import com.smart.model.UserInfo;
import com.smart.model.UserInfoCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class UserInfoServiceImpl extends BaseEntityService<UserInfo, UserInfoCond, Long> implements UserInfoService{

	@Autowired
	private UserInfoDao dao;
	
	@Override
	protected BaseDao<UserInfo, UserInfoCond, Long> getDao() {
		return dao;
	}
	
	
}
