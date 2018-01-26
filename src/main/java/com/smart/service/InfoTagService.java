package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.InfoTag;
import com.smart.model.InfoTagCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface InfoTagService extends BaseService<InfoTag, InfoTagCond, Long>{

}
