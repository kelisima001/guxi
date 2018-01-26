package com.smart.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Web 工具类
 * 
 * @author Sunxin
 *
 */
public class WebUtil {
	public static boolean isAjaxRequest(HttpServletRequest request){  
	    String header = request.getHeader("X-Requested-With");  
	    boolean isAjax = "XMLHttpRequest".equalsIgnoreCase(header) ? true:false;  
	    return isAjax;  
	}  
}
