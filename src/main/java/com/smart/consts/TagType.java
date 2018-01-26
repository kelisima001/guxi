package com.smart.consts;
/**
 * 枚举常量 - 标签类型
 * 
 * @author Sunxin
 *
 */
public enum TagType {
	
	product("产品"), info("资讯");
	
	String description;

	TagType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
