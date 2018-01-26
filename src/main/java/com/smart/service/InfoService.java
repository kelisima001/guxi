package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.Info;
import com.smart.model.InfoCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface InfoService extends BaseService<Info, InfoCond, Long>{

}
