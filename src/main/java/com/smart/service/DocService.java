package com.smart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.smart.consts.DocType;
import com.smart.model.Doc;
import com.smart.model.DocCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface DocService extends BaseService<Doc, DocCond, Long>{
	List<Doc> listDocByTypeWithoutContent(DocType type);
}
