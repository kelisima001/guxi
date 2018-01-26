package com.smart.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Role;
import com.smart.model.SelectItem;
import com.smart.model.User;
import com.smart.model.UserCond;

@Transactional(readOnly=true)
public interface UserService extends BaseService<User, UserCond, Long>{
	public Page<User> findBy(DetachedCriteria dc, PageRequest pageRequest);
	public UserDetails loadUserByUsername(String username);
	
	public List<User> findByRoleAndCity(Role role, SelectItem city);
	User findUserByTel(String tel);
	User findUserByOpenId(String openid);
	
	List<User> findUsersByParent(Long id);
	
	public List<User> findTop10ByProfit();
	
	
}
