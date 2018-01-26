package com.smart.model;

import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户留言/建议
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "Suggestion") 
public class Suggestion extends BaseEntity<Suggestion>{
	private static final long serialVersionUID = 1L;
	public static final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	
	private String name;
	@Column(length=1024)
	private String content;
	private String email;
	private String tel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
