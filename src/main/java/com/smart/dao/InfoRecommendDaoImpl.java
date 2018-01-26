package com.smart.dao;
 
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.smart.consts.InfoRecommendType;
import com.smart.model.InfoRecommend;
import com.smart.model.InfoRecommendCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class InfoRecommendDaoImpl extends BaseEntityDao<InfoRecommend, InfoRecommendCond, Long> implements InfoRecommendDao{

	@Override
	public boolean recommendExists(InfoRecommendType type, Long infoId) {
		Criteria crit = super.getSession().createCriteria(InfoRecommend.class);
		crit.createAlias("info", "inf")
				.add(Restrictions.eq("inf.id", infoId))
				.add(Restrictions.eq("type", type));
		return super.count(crit)>=1;
	}

}
