package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.CompanyHistory;
import com.smart.model.CompanyHistoryCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface CompanyHistoryService extends BaseService<CompanyHistory, CompanyHistoryCond, Long>{

}
