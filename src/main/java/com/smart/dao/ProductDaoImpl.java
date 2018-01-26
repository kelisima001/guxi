package com.smart.dao;
 
import org.springframework.stereotype.Repository;

import com.smart.model.Product;
import com.smart.model.ProductCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Repository
public class ProductDaoImpl extends BaseEntityDao<Product, ProductCond, Long> implements ProductDao{

}
