package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.Software;
import com.smart.model.SoftwareCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class SoftwareDaoImpl extends BaseEntityDao<Software, SoftwareCond, Long> implements SoftwareDao{

}
