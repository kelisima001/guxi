package com.smart.consts;
/**
 * 枚举常量 - 状态
 * 
 * @author Sunxin
 *
 */
public enum Status {
	
	active("可用"), inactive("不可用");
	
	String description;

	Status(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
