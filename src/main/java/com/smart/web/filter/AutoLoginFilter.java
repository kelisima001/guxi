package com.smart.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.smart.core.SpringContext;
import com.smart.model.User;
import com.smart.service.UserService;

/**
 * 自动登录过滤器
 * 
 * @author Sunxin
 *
 */
public class AutoLoginFilter implements Filter{
	public  static final Logger logger = Logger.getLogger(AutoLoginFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
        if(user==null){
        	Cookie[] cookies = req.getCookies();
        	if(cookies!=null && cookies.length!=0){
	        	for(Cookie cookie : cookies){
	        		if("loginUserName".equalsIgnoreCase(cookie.getName())){
	        			String username = cookie.getValue();
	        			UserService userService = SpringContext.getBean(UserService.class);
	        			User me = userService.findOneBy("username", username);
	        			me.setLastLogin(new Date());
	        			userService.save(me);
	        			session.setAttribute("user", me);
	        			break;
	        		}
	        	}
        	}
        }
        chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}
