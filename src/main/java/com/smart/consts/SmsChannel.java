package com.smart.consts;

/**
 * 短信发送候选渠道
 * 
 * @author Sunxin
 *
 */
public enum SmsChannel {
	ucpaas("云之讯");
	String description;

	SmsChannel(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
