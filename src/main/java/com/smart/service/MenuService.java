package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.Menu;
import com.smart.model.MenuCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface MenuService extends BaseService<Menu, MenuCond, Long>{

}
