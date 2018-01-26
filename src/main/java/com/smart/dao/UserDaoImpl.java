package com.smart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.smart.model.Role;
import com.smart.model.SelectItem;
import com.smart.model.User;
import com.smart.model.UserCond;

@Repository
public class UserDaoImpl extends BaseEntityDao<User, UserCond, Long> implements UserDao {
	@Override
	public Page<User> findBy(DetachedCriteria dc, PageRequest pageRequest){
		Criteria crit = dc.getExecutableCriteria(super.getSession());
		return super.findPage(pageRequest, crit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByEmailAndPassword(String email, String password) {
		Criteria crit = super.getSession().createCriteria(User.class);
		crit.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password))
				.add(Restrictions.eq("status", "ACTV"));
		List<User> users = crit.list();
		if(users!=null && users.size()!=0){
			return users.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByEmail(String email) {
		Criteria crit = super.getSession().createCriteria(User.class);
		crit.add(Restrictions.eq("email", email));
		List<User> users = crit.list();
		if(users!=null && users.size()!=0){
			return users.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User findByTel(String tel) {
		super.getSession().clear();
		Criteria crit = super.getSession().createCriteria(User.class);
		crit.add(Restrictions.eq("tel", tel));
		List<User> users = crit.list();
		if(users!=null && users.size()!=0){
			return users.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User findUserByOpenId(String openid) {
		super.getSession().clear();
		Criteria crit = super.getSession().createCriteria(User.class);
		crit.add(Restrictions.eq("wxOpenId", openid));
		List<User> users = crit.list();
		if(users!=null && users.size()!=0){
			return users.get(0);
		}
		return null;
	} 

	@Override
	@SuppressWarnings("unchecked")
	public UserDetails loadUserByUsername(String username){
		Criteria crit = super.getSession().createCriteria(User.class);
		crit.add(Restrictions.eq("username", username));
		List<User> users = crit.list();
		if(users!=null && users.size()!=0){
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<User> findByRoleAndCity(Role role, SelectItem city) {
		Criteria crit = super.getSession().createCriteria(User.class);
		crit.add(Restrictions.eq("role", role));
		crit.add(Restrictions.eq("city", city));
		return super.find(crit);
	}

	@Override
	public List<User> findUsersByParent(Long id) {
		Criteria crit = super.getSession().createCriteria(User.class);
		crit.createAlias("parent", "p");
		crit.add(Restrictions.eq("p.id", id));
		return super.find(crit);
	}

	@Override
	public List<User> findTop10ByProfit() {
		Criteria crit = super.getSession().createCriteria(User.class);
		crit.add(Restrictions.eq("role", Role.ROLE_USER));
		crit.setMaxResults(10);
		crit.addOrder(Order.desc("totalProfit"));
		return super.find(crit);
	}
}
