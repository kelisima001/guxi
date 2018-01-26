package com.smart.model;

import java.util.ArrayList;
import java.util.List;

import com.smart.util.StringUtil;

/**
 * 查询条件基础类
 * 
 * 请注意: 基础数据类型short int long double float boolean需要使用包装类型
 * @author Sunxin
 *
 */
public class BaseQueryCond {
	
	/**
	 * 排序字段, 如果升序, 使用~columnName; 否则直接放columnName;
	 */
	private List<String> orderBy = new ArrayList<String>();

	public List<String> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<String> orderBy) {
		this.orderBy = orderBy;
	}
	
	public void addOrderBy(String orderBy){
		if(StringUtil.isEmpty(orderBy)){
			return;
		}
		this.orderBy.add(orderBy);
	}
	
	public void addOrderByAsc(String orderBy){
		if(StringUtil.isEmpty(orderBy)){
			return;
		}
		this.orderBy.add("~" + orderBy);
	}
	
	public void addOrderByDesc(String orderBy){
		if(StringUtil.isEmpty(orderBy)){
			return;
		}
		this.orderBy.add(orderBy);
	}
	
	
}
