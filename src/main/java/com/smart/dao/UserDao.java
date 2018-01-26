package com.smart.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.model.Role;
import com.smart.model.SelectItem;
import com.smart.model.User;
import com.smart.model.UserCond;

public interface UserDao extends BaseDao<User, UserCond, Long>{
	
	public Page<User> findBy(DetachedCriteria dc, PageRequest pageRequest);

	public User findByEmailAndPassword(String email, String password);

	public User findByEmail(String email);
	public User findByTel(String tel);
	
	public UserDetails loadUserByUsername(String username);

	public List<User> findByRoleAndCity(Role role, SelectItem city);

	public User findUserByOpenId(String openid);

	public List<User> findUsersByParent(Long id);

	public List<User> findTop10ByProfit();
	
}