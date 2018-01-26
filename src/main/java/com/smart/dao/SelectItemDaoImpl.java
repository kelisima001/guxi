package com.smart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.smart.model.SelectItem;
import com.smart.model.SelectItemCond;
import com.smart.model.SelectType;

@Repository
public class SelectItemDaoImpl extends BaseEntityDao<SelectItem, SelectItemCond, Long> implements SelectItemDao {

	@Override
	public SelectItem findByCode(String code) {
		return super.findOneBy("code", code);
	}
	
	@Override
	public List<SelectItem> findBySelectTypeId(Long id){
		return super.findBy("selectType.id", id);
	}

	@Override
	public List<SelectItem> findBySelectType(SelectType selectType){
		return super.findBy("selectType.id", selectType.getId());
	}
	
	@Override
	public List<SelectItem> findByParentId(Long id){
		return super.findBy("parent.id", id);
	}
	
	@Override
	public List<SelectItem> findByParentCode(String code){
		return super.findBy("parent.code", code);
	}
	
	@Override
	public List<SelectItem> findByParent(SelectItem parent){
		return super.findBy("parent.id", parent.getId());
	}

	@Override
	public List<SelectItem> findBySelectTypeCode(String code) {
		Criteria crit = this.getSession().createCriteria(SelectItem.class);
		crit.add(Restrictions.eq("selectType.code", code));
		return super.find(crit);
	}
}
