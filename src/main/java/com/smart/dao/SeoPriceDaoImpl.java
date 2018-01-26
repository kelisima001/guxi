package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.SeoPrice;
import com.smart.model.SeoPriceCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class SeoPriceDaoImpl extends BaseEntityDao<SeoPrice, SeoPriceCond, Long> implements SeoPriceDao{

}
