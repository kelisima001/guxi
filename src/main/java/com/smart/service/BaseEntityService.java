package com.smart.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.smart.dao.BaseDao;
import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.BaseEntity;
import com.smart.model.BaseQueryCond;

public abstract class BaseEntityService<T extends BaseEntity<T>, Q extends BaseQueryCond, ID extends Serializable> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	abstract protected  BaseDao<T, Q, ID> getDao();
	
	public T findOne(ID id){
		Assert.notNull(id);
		return getDao().findOne(id);
	}
	
	public void save(T entity) {
		Assert.notNull(entity);
		if(entity.getId()==null) {
			entity.setTimeCreated(new Date());
		}
		entity.setTimeUpdated(new Date());
		getDao().save(entity);
	}

	public void delete(T entity) {
		Assert.notNull(entity);
		getDao().delete(entity);
	}

	public void delete(ID id) {
		Assert.notNull(id);
		getDao().delete(id);
	}
	
	public T findOneBy(String prop, Object val){
		Assert.notNull(prop);
		return getDao().findOneBy(prop, val);
	}
	
	public List<T> findBy(String prop, Object val){
		Assert.notNull(prop);
		return getDao().findBy(prop, val);
	}
	
	public List<T> findBy(Map<String, Object> props){
		return getDao().findBy(props);
	}
	
	public Page<T> findAll(PageRequest pageRequest){
		return getDao().findAll(pageRequest);
	}
	
	public Page<T> findAll(PageRequest pageRequest, Q cond) {
		return getDao().findPage(pageRequest, cond);
	}
	
	public Page<T> findAll(PageRequest pageRequest, Order order){
		return getDao().findAll(pageRequest, order);
	}
	
	public List<T> findAll(){
		return getDao().findAll();
	}
	
	public List<T> findLatestCreated(int count){
		return getDao().findLatestCreated(count);
	}
	
	public List<T> findLatestUpdated(int count){
		return getDao().findLatestUpdated(count);
	}
	
	public T findLatestUpdatedOne(){
		return getDao().findLatestUpdatedOne();
	}
	
	public T findLatestCreatedOne(){
		return getDao().findLatestCreatedOne();
	}
	
	public long count(Q cond) {
		return getDao().count(cond);
	}
	
	public List<T> find(Q cond) {
		return getDao().find(cond);
	}
	
	public T findOne(Q cond) {
		return getDao().findOne(cond);
	}
	
}
