package com.smart.model;

public enum Role {
	ROLE_USER("普通用户"), ROLE_ADMIN("管理员"), ROLE_SUPER_ADMIN("超级管理员");
	
	private String description;
	
	Role(String description){
		this.description = description;
	}
	
	public String getName() {
		return this.name();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
