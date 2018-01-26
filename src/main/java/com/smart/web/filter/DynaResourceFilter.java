package com.smart.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class DynaResourceFilter implements Filter{
	public  static final Logger logger = Logger.getLogger("web");
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		
        if(isCorePath(uri)){
        	setNoCacheForCorePath(res);
        }
        chain.doFilter(request, response);
	}
	
	private void setNoCacheForCorePath(HttpServletResponse response){
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragrma","no-cache");
		response.setHeader("_core_","1");
		response.setDateHeader("Expires",0);
	}

	private boolean isCorePath(String uri){
		if(uri.contains("/index") 
				|| uri.contains("/list")
				|| uri.contains("/school")
				|| uri.contains("/map")
				|| uri.contains("/view")
				|| uri.contains("/register")
				|| uri.contains("/login")
				|| uri.contains("/mapSearch")){
			return true;
		}
		return false;
	}
	
	@Override
	public void destroy() {
		
	}

}
