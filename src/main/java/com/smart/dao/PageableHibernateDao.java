package com.smart.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.util.Assert;

import com.smart.model.BaseQueryCond;
import com.smart.util.ReflectionUtils;

/**
 * 扩展分页查询功能.
 * @param <T> DAO操作的对象类型
 * @param <PK> 主键类型
 * @author calvin
 */
public class PageableHibernateDao<T, Q extends BaseQueryCond, PK extends Serializable> extends SimpleHibernateDao<T, Q, PK> {
	/**
	 * 用于Dao层子类的构造函数.
	 * 通过子类的泛型定义取得对象类型Class.
	 * eg.
	 * public class UserDao extends HibernateDao<User, Long>{
	 * }
	 */
	public PageableHibernateDao() {
		super();
	}

	/**
	 * 用于省略Dao层, Service层直接使用通用HibernateDao的构造函数.
	 * 在构造函数中定义对象类型Class.
	 * eg.
	 * HibernateDao<User, Long> userDao = new HibernateDao<User, Long>(sessionFactory, User.class);
	 */
	public PageableHibernateDao(final SessionFactory sessionFactory, final Class<T> entityClass) {
		super(sessionFactory, entityClass);
	}

	//-- 分页查询函数 --//

	/**
	 * 分页获取全部对象.
	 */
	public Page<T> findAll(PageRequest pageRequest) {
		return findPage(pageRequest);
	}
	
	/**
	 * 分页获取全部对象; 按创建时间倒排序
	 */
	public Page<T> findAll(PageRequest pageRequest, Order order) {
		return findPage(pageRequest, order);
	}
	
	/**
	 * 按HQL分页查询.
	 * @param pageRequest 分页参数.
	 * @param hql hql语句.
	 * @param values 数量可变的查询参数,按顺序绑定.
	 * @return 分页查询结果, 附带结果列表及所有查询输入参数.
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(PageRequest pageRequest, final String hql, final Object... values) {
		Assert.notNull(pageRequest, "pageRequest不能为空");

		Query q = createQuery(hql, values);

		long totalCount = countHqlResult(hql, values);
		pageRequest.setTotal(totalCount);

		setPageParameterToQuery(q, pageRequest);

		List<T> result = q.list();
		return new Page<T>(result, pageRequest);
	}

	/**
	 * 按HQL分页查询.
	 * @param pageRequest 分页参数.
	 * @param hql hql语句.
	 * @param values 命名参数,按名称绑定.
	 * @return 分页查询结果, 附带结果列表及所有查询输入参数.
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(PageRequest pageRequest, final String hql, final Map<String, ?> values) {
		Assert.notNull(pageRequest, "pageRequest不能为空");

		Query q = createQuery(hql, values);

		long totalCount = countHqlResult(hql, values);
		pageRequest.setTotal(totalCount);

		setPageParameterToQuery(q, pageRequest);

		List<T> result = q.list();
		return new Page<T>(result, pageRequest);
	}

	@SuppressWarnings("unchecked")
	public Page<T> findPage(PageRequest pageRequest, final Q cond) {
		Assert.notNull(pageRequest, "pageRequest不能为空");

		Criteria c = createCriteria(cond);
		long totalCount = countCriteriaResult(c);
		pageRequest.setTotal(totalCount);

		setPageParameterToCriteria(c, pageRequest);

		List<T> result = c.list();
		return new Page<T>(result, pageRequest);
	}
	
	/**
	 * 按Criteria分页查询.
	 * @param pageRequest 分页参数.
	 * @param criterions 数量可变的Criterion.
	 * 
	 * @return 分页查询结果.附带结果列表及所有查询输入参数.
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(PageRequest pageRequest, final Criteria c) {
		Assert.notNull(pageRequest, "pageRequest不能为空");
		c.addOrder(Order.desc("id"));
		long totalCount = countCriteriaResult(c);
		pageRequest.setTotal(totalCount);

		setPageParameterToCriteria(c, pageRequest);

		List<T> result = c.list();
		return new Page<T>(result, pageRequest);
	}
	
	/**
	 * 按Criteria分页查询.
	 * @param pageRequest 分页参数.
	 * @param criterions 数量可变的Criterion.
	 * 
	 * @return 分页查询结果.附带结果列表及所有查询输入参数.
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(PageRequest pageRequest, final Criterion... criterions) {
		Assert.notNull(pageRequest, "pageRequest不能为空");

		Criteria c = createCriteria(criterions);
		c.addOrder(Order.desc("id"));

		long totalCount = countCriteriaResult(c);
		pageRequest.setTotal(totalCount);

		setPageParameterToCriteria(c, pageRequest);

		List<T> result = c.list();
		return new Page<T>(result, pageRequest);
	}
	
	/**
	 * 按Criteria分页查询.
	 * @param pageRequest 分页参数.
	 * @param criterions 数量可变的Criterion.
	 * 
	 * @return 分页查询结果.附带结果列表及所有查询输入参数.
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(PageRequest pageRequest, Order order) {
		Assert.notNull(pageRequest, "pageRequest不能为空");

		Criteria c = createCriteria();

		long totalCount = countCriteriaResult(c);
		pageRequest.setTotal(totalCount);

		setPageParameterToCriteria(c, pageRequest);
		c.addOrder(order);
		
		List<T> result = c.list();
		return new Page<T>(result, pageRequest);
	}

	/**
	 * 设置分页参数到Query对象,辅助函数.
	 */
	protected Query setPageParameterToQuery(final Query q, PageRequest pageRequest) {
		q.setFirstResult(pageRequest.getOffset());
		q.setMaxResults(pageRequest.getLimit());
		return q;
	}

	/**
	 * 设置分页参数到Criteria对象,辅助函数.
	 */
	protected Criteria setPageParameterToCriteria(final Criteria c, PageRequest pageRequest) {
		//hibernate的firstResult的序号从0开始
		c.setFirstResult(pageRequest.getOffset());
		c.setMaxResults(pageRequest.getLimit());
		//TODO 添加排序支持
		return c;
	}

	/**
	 * 执行count查询获得本次Hql查询所能获得的对象总数.
	 * 本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
	 */
	protected long countHqlResult(final String hql, final Object... values) {
		String countHql = prepareCountHql(hql);

		try {
			Long count = findUnique(countHql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}

	/**
	 * 执行count查询获得本次Hql查询所能获得的对象总数.
	 * 本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
	 */
	protected long countHqlResult(final String hql, final Map<String, ?> values) {
		String countHql = prepareCountHql(hql);

		try {
			Long count = findUnique(countHql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}

	private String prepareCountHql(String orgHql) {
		String fromHql = orgHql;
		//select子句与order by子句会影响count查询,进行简单的排除.
		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");

		String countHql = "select count(*) " + fromHql;
		return countHql;
	}


}
