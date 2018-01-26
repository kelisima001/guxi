package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.CompanyHistory;
import com.smart.model.CompanyHistoryCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class CompanyHistoryDaoImpl extends BaseEntityDao<CompanyHistory, CompanyHistoryCond, Long> implements CompanyHistoryDao{

}
