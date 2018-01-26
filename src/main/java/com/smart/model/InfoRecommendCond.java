package com.smart.model;

import com.smart.consts.InfoRecommendType;

public class InfoRecommendCond extends BaseQueryCond {
	private InfoRecommendType type;

	public InfoRecommendType getType() {
		return type;
	}

	public void setType(InfoRecommendType type) {
		this.type = type;
	}
	
}
