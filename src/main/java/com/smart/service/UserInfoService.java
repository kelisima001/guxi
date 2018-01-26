package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.UserInfo;
import com.smart.model.UserInfoCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface UserInfoService extends BaseService<UserInfo, UserInfoCond, Long>{

}
