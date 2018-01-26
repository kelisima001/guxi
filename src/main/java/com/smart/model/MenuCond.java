package com.smart.model;

/**
 * 菜单查询条件类
 * 
 * @author Sunxin
 *
 */
public class MenuCond extends BaseQueryCond {
	
	private String code;
	
	private String parentId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
