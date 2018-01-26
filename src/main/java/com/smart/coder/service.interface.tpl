package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.{name};
import com.smart.model.{name}Cond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface {name}Service extends BaseService<{name}, {name}Cond, Long>{

}
