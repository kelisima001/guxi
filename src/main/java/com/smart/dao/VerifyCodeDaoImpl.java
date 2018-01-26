package com.smart.dao;
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.smart.model.VerifyCode;
import com.smart.model.VerifyCodeCond;
import com.smart.util.CollectionUtil;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class VerifyCodeDaoImpl extends BaseEntityDao<VerifyCode, VerifyCodeCond, Long> implements VerifyCodeDao{

	@Override
	public VerifyCode findLatestOneByMobile(String mobile) {
		Criteria crit = this.getSession().createCriteria(VerifyCode.class);
		crit.add(Restrictions.eq("mobile", mobile));
		crit.add(Restrictions.eq("used", false));
		crit.addOrder(Order.desc("timeCreated"));
		crit.setMaxResults(1);
		List<VerifyCode> list = super.find(crit);
		if(!CollectionUtil.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

}
