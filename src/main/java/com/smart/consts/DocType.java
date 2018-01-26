package com.smart.consts;

/**
 * 枚举常量 - 文档类型
 * 
 * @author Sunxin
 *
 */
public enum DocType {
	
	general("通用"), prod("产品");
	String description;

	DocType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
