package com.smart.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 随机图片验证码控制器
 * 
 * @author Sunxin
 *
 */
@Controller
public class CaptchaController extends BaseController{

	/**
	 * 生成验证码图片
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "genCaptcha")
	public void genCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		captchaService.genCaptcha(request, response);
		response.getOutputStream().flush();
	}
}