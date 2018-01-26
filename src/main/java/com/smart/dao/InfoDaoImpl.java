package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.Info;
import com.smart.model.InfoCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class InfoDaoImpl extends BaseEntityDao<Info, InfoCond, Long> implements InfoDao{
	
}
