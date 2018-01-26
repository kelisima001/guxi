package com.smart.dao;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smart.consts.DocType;
import com.smart.model.Doc;
import com.smart.model.DocCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class DocDaoImpl extends BaseEntityDao<Doc, DocCond, Long> implements DocDao{

	@Override
	public List<Doc> listDocByTypeWithoutContent(DocType type) {
		//Criteria crit = super.getSession().createCriteria(Doc.class);
		return null;
	}

}
