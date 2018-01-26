package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.Honor;
import com.smart.model.HonorCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface HonorService extends BaseService<Honor, HonorCond, Long>{

}
