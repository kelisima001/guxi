package com.smart.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.core.SpringContext;

public class SmartUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserService userService = (UserService) SpringContext.getBean(UserServiceImpl.class);
		UserDetails user = userService.loadUserByUsername(username);
		if(user==null){
			return user;
		}
		throw new UsernameNotFoundException("can't find user via username " + username);
	}

}
