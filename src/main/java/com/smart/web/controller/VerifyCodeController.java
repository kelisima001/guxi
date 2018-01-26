package com.smart.web.controller;

import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.VerifyCode;

/**
 * 短信验证码控制器
 * 
 * @author Sunxin
 *
 */
@Controller
public class VerifyCodeController extends BaseController{
	/**
	 * 当前session最近一次发送验证码时间对应的session key
	 */
	private static final String LAST_SENT_TIME_KEY = "lastSentTime"; 
	/**
	 * 每个session发送验证码的最小时间间隔 - 秒
	 */
	private static final long MIN_INTERVAL_IN_SECOND = 30;
	/**
	 * 每个session发送验证码的最小时间间隔 - 毫秒
	 */
	private static final long MIN_INTERVAL_IN_MIL = MIN_INTERVAL_IN_SECOND * 1000;
	/**
	 * 手机号正则表达式
	 */
	private static final Pattern MOBILE_PATTERN = Pattern.compile("^\\d{11}$");
	@RequestMapping(value = "admin/listVerifyCode")
	public String listDict(PageRequest pageRequest, Model model){
		Page<VerifyCode> page = verifyCodeService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/listVerifyCode";
	}
	
	/**
	 * 页面请求生成验证码并发送到手机号
	 * @param mobile 手机号
	 * @return
	 */
	@RequestMapping(value = "sendVerifyCode")
	public @ResponseBody String sendVerifyCode(HttpSession session, String mobile){
		if(!isValidMobile(mobile)){
			return "BAD1";
		}
		Date lastSentTime = (Date) session.getAttribute(LAST_SENT_TIME_KEY);
		if(lastSentTime!=null){
			Date now = new Date();
			long interval = now.getTime() - lastSentTime.getTime();
			if(interval < MIN_INTERVAL_IN_MIL){
				return "BAD2";
			}
		}
		String code = generateCode(4);
		boolean success = verifyCodeService.sendVerifyCode(mobile, code);
		
		VerifyCode verifyCode = new VerifyCode();
		verifyCode.setMobile(mobile);
		verifyCode.setCode(code);
		verifyCode.setSuccess(false);
		if(success){
			verifyCode.setSuccess(true);
		}
		else{
			return "BAD3";
		}
		verifyCodeService.save(verifyCode);
		session.setAttribute(LAST_SENT_TIME_KEY, new Date());
		return "OK";
	}

	private static boolean isValidMobile(String mobile) {
		Matcher matcher = MOBILE_PATTERN.matcher(mobile);
		if(matcher.find()){
			return true;
		}
		return false;
	}
	
	/**
	 * 产生随机验证码
	 * @param length 验证码长度
	 * @return
	 */
	private static String generateCode(int length){
		if(length<4 || length > 10){
			length = 4;
		}
		Random random = new Random();
		String result = "";
		for(int i=0; i< length; i++){
			result += Math.abs(random.nextInt()%10);
		}
		return result;
		
	}
	
	public static void main(String[] args){
		System.out.println(isValidMobile("15555555055"));
		System.out.println(generateCode(4));
		//System.out.println(new Double(Math.pow(10, 4)).intValue());
	}
	
}
