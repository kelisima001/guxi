package com.smart.model;

import com.smart.dao.annotation.Expression;

public class InfoCond extends BaseQueryCond{
	
	@Expression(property="id", operator=">")
	private Long idGt;
	
	@Expression(property="id", operator="<")
	private Long idLe;
	
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 来源
	 */
	private String source;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 类型
	 */
	@Expression(property = "type.id")
	private Long typeId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getIdGt() {
		return idGt;
	}
	public void setIdGt(Long idGt) {
		this.idGt = idGt;
	}
	public Long getIdLe() {
		return idLe;
	}
	public void setIdLe(Long idLe) {
		this.idLe = idLe;
	}
}
