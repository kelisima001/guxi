package com.smart.service;

import org.springframework.transaction.annotation.Transactional;

import com.smart.model.Product;
import com.smart.model.ProductCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Transactional(readOnly=true)
public interface ProductService extends BaseService<Product, ProductCond, Long>{

}
