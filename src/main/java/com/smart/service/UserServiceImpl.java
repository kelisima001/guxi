package com.smart.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.dao.UserDao;
import com.smart.model.Role;
import com.smart.model.SelectItem;
import com.smart.model.User;
import com.smart.model.UserCond;

@Service
public class UserServiceImpl extends BaseEntityService<User, UserCond, Long> implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	protected BaseDao<User, UserCond, Long> getDao() {
		return userDao;
	}
	
	@Override
	public Page<User> findBy(DetachedCriteria dc, PageRequest pageRequest){
		return userDao.findBy(dc, pageRequest);
	}
	@Override
	public User findUserByTel(String tel) {
		return userDao.findByTel(tel);
	}
	@Override
	public User findUserByOpenId(String openid) {
		return userDao.findUserByOpenId(openid);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		UserDetails user = userDao.loadUserByUsername(username);
		return user;
	}

	@Override
	public List<User> findByRoleAndCity(Role role, SelectItem city) {
		return userDao.findByRoleAndCity(role, city);
	}

	@Override
	public List<User> findUsersByParent(Long id) {
		return userDao.findUsersByParent(id);
	}

	@Override
	public List<User> findTop10ByProfit() {
		return userDao.findTop10ByProfit();
	}
}
