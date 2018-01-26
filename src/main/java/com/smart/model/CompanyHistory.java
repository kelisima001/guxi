package com.smart.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "CompanyHistory") 
public class CompanyHistory extends BaseEntity<CompanyHistory>{
	private static final long serialVersionUID = 1L;
	
	private String date;
	
	private String event;
	
	private String description;

	private String image;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
