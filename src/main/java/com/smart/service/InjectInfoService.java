package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.InjectInfo;
import com.smart.model.InjectInfoCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface InjectInfoService extends BaseService<InjectInfo, InjectInfoCond, Long>{

}
