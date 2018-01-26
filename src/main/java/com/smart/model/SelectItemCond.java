package com.smart.model;

import com.smart.dao.annotation.Expression;

public class SelectItemCond extends BaseQueryCond{
	private String name;
	
	@Expression(property = "selectType.id")
	private Long selectTypeId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSelectTypeId() {
		return selectTypeId;
	}

	public void setSelectTypeId(Long selectTypeId) {
		this.selectTypeId = selectTypeId;
	}
	
	
}
