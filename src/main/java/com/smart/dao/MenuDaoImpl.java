package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.Menu;
import com.smart.model.MenuCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class MenuDaoImpl extends BaseEntityDao<Menu, MenuCond, Long> implements MenuDao{

}
