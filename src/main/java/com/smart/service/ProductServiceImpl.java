package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.ProductDao;
import com.smart.model.Product;
import com.smart.model.ProductCond;

/**
 * 
 * @author Sunxin
 *
 */
 
@Service
public class ProductServiceImpl extends BaseEntityService<Product, ProductCond, Long> implements ProductService{

	@Autowired
	private ProductDao dao;
	
	@Override
	protected BaseDao<Product, ProductCond, Long> getDao() {
		return dao;
	}
	
	
}
