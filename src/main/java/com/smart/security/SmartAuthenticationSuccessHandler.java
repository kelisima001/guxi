package com.smart.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.smart.model.User;

/**
 * A post authentication handler that is capable for saving current principal into session;
 * @author sunxing
 *
 */
public class SmartAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			Object obj = auth.getPrincipal();
			if(obj instanceof User){
				request.getSession().setAttribute("user", obj);
			}
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
