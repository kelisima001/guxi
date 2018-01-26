package com.smart.consts;

/**
 * 信息类型
 * 
 * @author Sunxin
 *
 */
public enum InfoType {
	
	hgView("弘鸽视角"), mediaReport("媒体报道");
	
	String description;

	InfoType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
