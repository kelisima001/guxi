package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.SuggestionDao;
import com.smart.model.Suggestion;
import com.smart.model.SuggestionCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class SuggestionServiceImpl extends BaseEntityService<Suggestion, SuggestionCond, Long> implements SuggestionService{

	@Autowired
	private SuggestionDao dao;
	
	@Override
	protected BaseDao<Suggestion, SuggestionCond, Long> getDao() {
		return dao;
	}
	
	
}
