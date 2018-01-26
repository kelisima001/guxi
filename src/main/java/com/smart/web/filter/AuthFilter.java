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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.smart.model.User;

public class AuthFilter implements Filter{
	public  static final Logger logger = Logger.getLogger(AuthFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		User user = (User)session.getAttribute("user");
        if(isAdminPath(uri)){
        	if(user==null || !user.isAdmin()){
        		res.sendRedirect(req.getContextPath() + "/admin/login");
        		return;
        	}
        }
        if(isLoginRequired(uri)){
        	if(user==null){
        		res.sendRedirect(req.getContextPath() + "/login");
        		return;
        	}
        }
        chain.doFilter(new RequestWrapper(req), response);
	}

	private boolean isLoginRequired(String uri){
		if(uri.toLowerCase().contains("/user/")){
			return true;
		}
		return false;
	}
	
	private boolean isAdminPath(String uri){
		if(uri.toLowerCase().contains("/admin") && !uri.toLowerCase().contains("/admin/login")
				&& !uri.toLowerCase().contains("/admin/logout")){
			return true;
		}
		return false;
	}

	// get the real IP address under complicated network conditions 
	protected String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	@Override
	public void destroy() {
		
	}
}
