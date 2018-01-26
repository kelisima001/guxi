package com.smart.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "UserInfo") 
public class UserInfo extends BaseEntity<UserInfo>{
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private String salary;
	
	private String channel;
	
	private String detail;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
