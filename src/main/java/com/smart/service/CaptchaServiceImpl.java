package com.smart.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.smart.consts.SessionKeys;
import com.smart.util.CaptchaUtil;

@Service
public class CaptchaServiceImpl implements CaptchaService{

	@Override
	public void genCaptcha(HttpServletRequest request, HttpServletResponse response) {
		CaptchaUtil util = new CaptchaUtil();
		util.genCaptcha(request, response);
	}

	@Override
	public boolean verifyCaptcha(HttpServletRequest req, String code) {
		String code1 = (String)req.getSession().getAttribute(SessionKeys.CAHTCHA);
		if(code1==null || code==null){
			return false;
		}
		if(!code1.equalsIgnoreCase(code)){
			return false;
		}
		req.getSession().removeAttribute(SessionKeys.CAHTCHA);
		return true;
	}

}
