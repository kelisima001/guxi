package com.smart.dao;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smart.model.BaseEntity;
import com.smart.model.BaseQueryCond;

/**
 * 实体DAO实现，继承自{@link HibernateDao}，实现{@link BaseDao}接口
 * @param <T> 实体类型
 * @param <PK> 主键类型
 * @author xs06974
 */
public class BaseEntityDao<T extends BaseEntity<?>, Q extends BaseQueryCond, ID extends Serializable> extends PageableHibernateDao<T, Q, ID> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 用于Dao层子类使用的构造函数.
	 * 通过子类的泛型定义取得对象类型Class.
	 * eg.
	 * public class UserDao extends BaseDaoImpl<User, Long>{}
	 */
	public BaseEntityDao() {
		super();
	}

}
