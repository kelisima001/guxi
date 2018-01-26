package com.smart.model;

import com.smart.dao.annotation.Expression;

public class InfoTagCond extends BaseQueryCond {
	
	@Expression(property = "info.id")
	private Long infoId;
	
	@Expression(property = "tag.id")
	private Long tagId;

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	
}
