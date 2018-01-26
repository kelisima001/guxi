package com.smart.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.smart.model.User;

public class LoginSuccessFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			Object obj = auth.getPrincipal();
			if(obj instanceof User){
				request.getSession().setAttribute("user", obj);
			}
		}
		chain.doFilter(request, res);
	}

	@Override
	public void destroy() {
		
	}

}
