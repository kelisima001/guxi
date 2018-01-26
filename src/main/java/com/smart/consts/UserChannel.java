package com.smart.consts;

/**
 * 用户来源渠道
 * 
 * @author Sunxin
 *
 */
public enum UserChannel {
	wx("微信"), website("网站注册");
	String description;

	UserChannel(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
