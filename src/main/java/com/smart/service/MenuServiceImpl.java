package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.MenuDao;
import com.smart.model.Menu;
import com.smart.model.MenuCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class MenuServiceImpl extends BaseEntityService<Menu, MenuCond, Long> implements MenuService{

	@Autowired
	private MenuDao dao;
	
	@Override
	protected BaseDao<Menu, MenuCond, Long> getDao() {
		return dao;
	}
	
	
}
