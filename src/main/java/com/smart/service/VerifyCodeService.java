package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.VerifyCode;
import com.smart.model.VerifyCodeCond;

/**
 * 验证码服务接口
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface VerifyCodeService extends BaseService<VerifyCode, VerifyCodeCond, Long>{
	
	/**
	 * 发送验证码到手机
	 * @param mobile 手机号
	 * @param code 验证码
	 * @return
	 */
	boolean sendVerifyCode(String mobile, String code);
	
	/**
	 * 查找某手机号最近一次发送的可用的验证码
	 * @param mobile
	 * @return
	 */
	VerifyCode findLatestOneByMobile(String mobile);
	
	/**
	 * 验证验证码
	 * @param mobile
	 * @param code
	 * @return
	 */
	@Transactional(readOnly = false)
	boolean verity(String mobile, String code);
}
