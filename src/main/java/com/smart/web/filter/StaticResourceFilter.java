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

public class StaticResourceFilter implements Filter{
	public  static final Logger logger = Logger.getLogger("web");
	private static final long DAY_IN_SECONDS = 24L * 60 * 60;
	private static final long DAY_IN_MILSECONDS = 24L * 60 * 60 * 1000;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		
        chain.doFilter(request, response);

        if (isResource(uri)){
        	setCacheForResources(res);
        }
	}
	private void setCacheForResources(HttpServletResponse res) {
		res.setDateHeader("Expires", System.currentTimeMillis() + DAY_IN_MILSECONDS);
		res.setHeader("Cache-Control", "public, max-age=" + DAY_IN_SECONDS);
		res.setHeader("Pragma", "cache");
	}
	
	private boolean isResource(String uri){
		if (uri.toLowerCase().matches("\\S*/resources/\\S*") 
				|| uri.toLowerCase().matches("\\S*/static/\\S*")
        		|| uri.endsWith("html")
        		|| uri.endsWith(".jsp")
        		|| uri.endsWith(".jpg")
        		|| uri.endsWith(".png")
        		|| uri.endsWith(".gif")){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public void destroy() {
		
	}

}
