package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.InfoTag;
import com.smart.model.InfoTagCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class InfoTagDaoImpl extends BaseEntityDao<InfoTag, InfoTagCond, Long> implements InfoTagDao{

}
