package com.smart.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.smart.web.DeviceContextHolder;

public class DeviceFilter implements Filter{

	private static final String HEADER_USER_AGENT = "user-agent";
	private static final String KEYWORD_MOBILE = "mobile";
	private static final String KEYWORD_IPAD = "ipad";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		if(isMobileDevice(request)){
			DeviceContextHolder.setDeviceType("mobile");
		}
		else{
			DeviceContextHolder.setDeviceType("non_mobile");
		}
		
		chain.doFilter(req, res);
		
		DeviceContextHolder.clean();
	}

	@Override
	public void destroy() {
		
	}
	
	protected boolean isMobileDevice(HttpServletRequest request){
		String ua = request.getHeader(HEADER_USER_AGENT).toLowerCase();
		if(ua.indexOf(KEYWORD_MOBILE)!=-1 && ua.indexOf(KEYWORD_IPAD)==-1){
			return true;
		}
		return false;
	}

}
