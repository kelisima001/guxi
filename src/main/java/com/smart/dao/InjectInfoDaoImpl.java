package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.InjectInfo;
import com.smart.model.InjectInfoCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class InjectInfoDaoImpl extends BaseEntityDao<InjectInfo, InjectInfoCond, Long> implements InjectInfoDao{

}
