package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.SeoPrice;
import com.smart.model.SeoPriceCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface SeoPriceService extends BaseService<SeoPrice, SeoPriceCond, Long>{

}
