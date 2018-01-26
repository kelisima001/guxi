package com.smart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.dao.UserDao;

@Service("smartUserDetailService")
public class SmartUserDetailService implements UserDetailsService{

	@Autowired 
	private UserDao userDao;

	@Override 
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails user = userDao.loadUserByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("Can't load user via username " + username);
		}
		System.out.println(user.getAuthorities());
		return user;
	}
	
	
}
