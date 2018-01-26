package com.smart.consts;

public enum InfoRecommendType {
	home1("首页媒体报道"), home2("首页弘鸽视角");
	
	String description;

	InfoRecommendType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
