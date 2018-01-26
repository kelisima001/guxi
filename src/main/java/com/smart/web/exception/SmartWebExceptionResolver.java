package com.smart.web.exception;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.smart.exception.AppRtException;
import com.smart.util.CloseUtil;
import com.smart.util.JSON;
import com.smart.util.WebUtil;

/**
 * 
 * @author Sunxin
 *
 */
public class SmartWebExceptionResolver implements HandlerExceptionResolver {
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		boolean ajax = WebUtil.isAjaxRequest(request);
		if(ajax) {
			String json = createResponse(ex);
			try {
				response.setStatus(503);
				response.setContentType("application/json");
				response.getWriter().write(json);
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 返回空view从而不会再走后续异常处理链;
			return new ModelAndView();
			
		}
		else {
			ModelAndView errorView = new ModelAndView("error");
			errorView.addObject("系统错误", "请联系管理员或稍后重试");
			return errorView;
		}
	}
	
	private String createResponse(Exception ex) {
		Map<String, String> map = new HashMap<String, String>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		map.put("details", baos.toString());
		CloseUtil.close(baos, out);
		if(ex instanceof AppRtException) {
			AppRtException exception = (AppRtException) ex;
			map.put("code", exception.getCode());
			map.put("message", exception.getMessage());
		}
		else {
			map.put("code", "sys.001");
			map.put("message", "系统错误, 请联系管理员");
		}
		return JSON.getDefault().toJSONString(map);
	}

}
