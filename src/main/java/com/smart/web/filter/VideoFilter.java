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

public class VideoFilter implements Filter{
	public  static final Logger logger = Logger.getLogger(VideoFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String uri = req.getRequestURI();
        if(isVideoResource(uri)){
        	res.setHeader("Content-Type","video/mpeg");
        }
        chain.doFilter(req, res);
	}

	private boolean isVideoResource(String uri) {
		if(uri.contains("mp4")){  
			return true;
		}
		return false;
	}

	@Override
	public void destroy() {
		
	}
}
