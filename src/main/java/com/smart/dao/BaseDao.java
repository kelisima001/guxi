package com.smart.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.smart.model.BaseEntity;
import com.smart.model.BaseQueryCond;

/**
 * 
 * @author Sunxin
 *
 * @param <T>
 * @param <ID>
 */
public interface BaseDao<T extends BaseEntity<T>, Q extends BaseQueryCond, ID extends Serializable>{
	
	public T findOne(ID id);

	public void save(T entity);

	public void delete(T entity);

	public void delete(ID id);
	
	public List<T> findBy(String prop, Object val);
	
	public List<T> findBy(Map<String, Object> props);
	
	public T findOneBy(String prop, Object val);
	
	public Page<T> findAll(PageRequest pageRequest);
	
	public Page<T> findPage(PageRequest pageRequest, Q cond);
	
	public long count(Q cond);
	
	public List<T> find(Q cond);
	
	public T findOne(Q cond);
	/**
	 * 带排序的分页查找
	 */
	public Page<T> findAll(PageRequest pageRequest, Order order);
	
	public Page<T> findPage(PageRequest pageRequest, final Criteria c);
	
	public List<T> findAll();
	
	public List<T> findLatestCreated(int count);
	
	public List<T> findLatestUpdated(int count);
	
	public T findLatestUpdatedOne();
	
	public T findLatestCreatedOne();
}
