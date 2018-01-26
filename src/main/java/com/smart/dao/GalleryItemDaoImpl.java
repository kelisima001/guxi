package com.smart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.smart.model.GalleryItem;
import com.smart.model.GalleryItemCond;

/**
 * 
 * @author Sunxin
 *
 */

@Repository
public class GalleryItemDaoImpl extends BaseEntityDao<GalleryItem, GalleryItemCond, Long> implements GalleryItemDao {
	public List<GalleryItem> findByGalleryId(Long id) {
		Criteria crit = super.getSession().createCriteria(GalleryItem.class);
		crit.createAlias("gallery", "g")
				.add(Restrictions.eq("g.id", id))
				.addOrder(Order.desc("sort"));
		return super.find(crit);
	}
}
