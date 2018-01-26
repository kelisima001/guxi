package com.smart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "InjectInfo") 
public class InjectInfo extends BaseEntity<InjectInfo>{
	private static final long serialVersionUID = 1L;
	
	@Type(type="text") 
	@Column(nullable=true)
	private String url;
	
	@Type(type="text") 
	@Column(nullable=true)
	private String cookie;
	
	@Type(type="text") 
	@Column(nullable=true)
	private String detail;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
