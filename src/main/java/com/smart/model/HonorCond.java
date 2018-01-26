package com.smart.model;

import com.smart.dao.annotation.Expression;

public class HonorCond extends BaseQueryCond {
	
	@Expression(operator = "like", property = "title")
	private String titleLike;

	public String getTitleLike() {
		return titleLike;
	}

	public void setTitleLike(String titleLike) {
		this.titleLike = titleLike;
	}
	
	
}
