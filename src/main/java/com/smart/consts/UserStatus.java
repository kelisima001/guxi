package com.smart.consts;

public enum UserStatus {
	actv("正常"), inac("失效"), locked("锁定");
	String description;
	UserStatus(String description){
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
