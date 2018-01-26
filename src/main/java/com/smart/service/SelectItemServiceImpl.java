package com.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.SelectItemDao;
import com.smart.model.SelectItem;
import com.smart.model.SelectItemCond;
import com.smart.model.SelectType;

@Service
public class SelectItemServiceImpl extends BaseEntityService<SelectItem, SelectItemCond, Long> implements SelectItemService{

	@Autowired
	private SelectItemDao dao;
	
	@Override
	protected BaseDao<SelectItem, SelectItemCond, Long> getDao() {
		return dao;
	}

	@Override
	public SelectItem findByCode(String code) {
		return dao.findByCode(code);
	}

	@Override
	public List<SelectItem> findBySelectTypeId(Long id) {
		return dao.findBySelectTypeId(id);
	}

	@Override
	public List<SelectItem> findBySelectType(SelectType selectType) {
		return dao.findBySelectType(selectType);
	}

	@Override
	public List<SelectItem> findByParentId(Long id) {
		return dao.findByParentId(id);
	}

	@Override
	public List<SelectItem> findByParentCode(String code) {
		return dao.findByParentCode(code);
	}

	@Override
	public List<SelectItem> findByParent(SelectItem parent) {
		return dao.findByParent(parent);
	}

	@Override
	public List<SelectItem> findBySelectTypeCode(String code) {
		return dao.findBySelectTypeCode(code);
	}

}
