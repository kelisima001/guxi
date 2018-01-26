package com.smart.dao;

import com.smart.model.VerifyCode;
import com.smart.model.VerifyCodeCond;

/**
 * 
 * @author Sunxin
 *
 */
public interface VerifyCodeDao extends BaseDao<VerifyCode, VerifyCodeCond, Long>{

	VerifyCode findLatestOneByMobile(String mobile); 
	
}
