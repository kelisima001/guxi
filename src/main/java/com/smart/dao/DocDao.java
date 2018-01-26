package com.smart.dao;

import java.util.List;

import com.smart.consts.DocType;
import com.smart.model.Doc;
import com.smart.model.DocCond;

/**
 * 
 * @author Sunxin
 *
 */
public interface DocDao extends BaseDao<Doc, DocCond, Long>{

	List<Doc> listDocByTypeWithoutContent(DocType type); 
	
}
