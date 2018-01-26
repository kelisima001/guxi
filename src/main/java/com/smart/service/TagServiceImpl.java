package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.TagDao;
import com.smart.model.Tag;
import com.smart.model.TagCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class TagServiceImpl extends BaseEntityService<Tag, TagCond, Long> implements TagService{

	@Autowired
	private TagDao dao;
	
	@Override
	protected BaseDao<Tag, TagCond, Long> getDao() {
		return dao;
	}
	
	
}
