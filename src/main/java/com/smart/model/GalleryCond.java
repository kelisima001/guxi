package com.smart.model;

/**
 * 相册查询条件
 * 
 * @author Sunxin
 *
 */
public class GalleryCond extends BaseQueryCond{
	private String id;
	private String code;
	private String name;
	private String nameLike;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameLike() {
		return nameLike;
	}
	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}
	
	
}
