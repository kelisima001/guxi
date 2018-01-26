package com.smart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.SelectItem;
import com.smart.model.SelectItemCond;
import com.smart.model.SelectType;

@Transactional(readOnly=true)
public interface SelectItemService extends BaseService<SelectItem, SelectItemCond, Long>{
	public SelectItem findByCode(String code);
	public List<SelectItem> findBySelectTypeId(Long id);
	public List<SelectItem> findBySelectType(SelectType selectType);
	public List<SelectItem> findBySelectTypeCode(String code);
	public List<SelectItem> findByParentId(Long id);
	public List<SelectItem> findByParentCode(String code);
	public List<SelectItem> findByParent(SelectItem parent);
}
