package com.smart.dao;

import java.util.List;

import com.smart.model.SelectItem;
import com.smart.model.SelectItemCond;
import com.smart.model.SelectType;

public interface SelectItemDao extends BaseDao<SelectItem, SelectItemCond, Long>{
	public SelectItem findByCode(String code);
	public List<SelectItem> findBySelectTypeId(Long id);
	public List<SelectItem> findBySelectType(SelectType selectType);
	public List<SelectItem> findByParentId(Long id);
	public List<SelectItem> findByParentCode(String code);
	public List<SelectItem> findByParent(SelectItem parent);
	public List<SelectItem> findBySelectTypeCode(String code);
}