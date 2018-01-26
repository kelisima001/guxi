package com.smart.model;

import com.smart.consts.Status;
import com.smart.consts.TagType;

/**
 * 标签查询条件
 * 
 * @author Xin.Sun
 *
 */
public class TagCond extends BaseQueryCond {
	
	private TagType type;
	
	private Status status = Status.active;

	public TagType getType() {
		return type;
	}

	public void setType(TagType type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}

