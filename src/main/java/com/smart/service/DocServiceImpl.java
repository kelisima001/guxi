package com.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.consts.DocType;
import com.smart.dao.BaseDao;
import com.smart.dao.DocDao;
import com.smart.model.Doc;
import com.smart.model.DocCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class DocServiceImpl extends BaseEntityService<Doc, DocCond, Long> implements DocService{

	@Autowired
	private DocDao dao;
	
	@Override
	protected BaseDao<Doc, DocCond, Long> getDao() {
		return dao;
	}

	@Override
	public List<Doc> listDocByTypeWithoutContent(DocType type) {
		return dao.listDocByTypeWithoutContent(type);
	}
	
	
}
