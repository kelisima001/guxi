package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.Honor;
import com.smart.model.HonorCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class HonorDaoImpl extends BaseEntityDao<Honor, HonorCond, Long> implements HonorDao{

}
