package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.UserInfo;
import com.smart.model.UserInfoCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class UserInfoDaoImpl extends BaseEntityDao<UserInfo, UserInfoCond, Long> implements UserInfoDao{

}
