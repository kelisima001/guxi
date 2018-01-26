package com.smart.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.smart.consts.Status;
import com.smart.consts.TagType;

/**
 * 标签
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "Tag") 
public class Tag extends BaseEntity<Tag>{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 业务键
	 */
	private String code;
	
	/**
	 * 类型
	 */
	private TagType type = TagType.info;
	/**
	 * 状态
	 */
	private Status status = Status.active;
	
	/**
	 * 临时属性, 用来标记某对象是否已经被打了该tag
	 */
	@Transient
	private boolean used;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	
}
