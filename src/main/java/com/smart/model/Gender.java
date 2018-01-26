package com.smart.model;

/**
 * 枚举常量 - 性别
 * 
 * @author Sunxin
 *
 */
public enum Gender {
	
	male("男"), female("女");
	
	String description;

	Gender(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
