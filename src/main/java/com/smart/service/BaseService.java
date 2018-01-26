package com.smart.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.BaseEntity;
import com.smart.model.BaseQueryCond;


@Transactional(readOnly=true)
public interface BaseService<T extends BaseEntity<T>, Q extends BaseQueryCond, ID extends Serializable> {
	
	public T findOne(ID id);
	
	@Transactional(readOnly=false)
	public void save (T entity);
	
	@Transactional(readOnly=false)
	public void delete (T entity);
	
	@Transactional(readOnly=false)
	public void delete (ID id);
	
	public T findOneBy(String prop, Object val);
	
	public List<T> findBy(String prop, Object val);
	
	public List<T> findBy(Map<String, Object> props);
	
	public List<T> find(Q cond);
	
	public T findOne(Q cond);
	
	public Page<T> findAll(PageRequest pageRequest);
	
	public Page<T> findAll(PageRequest pageRequest, Q cond);
	
	public long count(Q cond);
	
	public Page<T> findAll(PageRequest pageRequest, Order order);
	
	public List<T> findAll();
	
	public List<T> findLatestCreated(int count);
	
	public List<T> findLatestUpdated(int count);
	
	public T findLatestUpdatedOne();
	
	public T findLatestCreatedOne();
}
