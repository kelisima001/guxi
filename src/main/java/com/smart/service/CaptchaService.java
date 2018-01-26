package com.smart.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片验证码服务
 * 
 * @author Sunxin
 *
 */
public interface CaptchaService {
	/**
	 * 生成图片验证码
	 * 
	 * @param request
	 * @param response
	 */
	public void genCaptcha(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 校验图片验证码
	 * @param req
	 * @param code
	 * @return
	 */
	public boolean verifyCaptcha(HttpServletRequest req, String code);
}
