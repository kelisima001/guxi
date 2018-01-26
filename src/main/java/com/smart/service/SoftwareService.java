package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.Software;
import com.smart.model.SoftwareCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface SoftwareService extends BaseService<Software, SoftwareCond, Long>{

}
