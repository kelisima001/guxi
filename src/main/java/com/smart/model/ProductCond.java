package com.smart.model;

import com.smart.dao.annotation.Expression;

public class ProductCond extends BaseQueryCond {
	
	@Expression(operator = "like", property = "name")
	private String nameLike;
	
	@Expression(property = "type.id")
	private Long typeId;

	public String getNameLike() {
		return nameLike;
	}

	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	
}
