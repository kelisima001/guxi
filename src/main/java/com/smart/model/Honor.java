package com.smart.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * 荣誉
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "Honor") 
public class Honor extends BaseEntity<Honor>{
	private static final long serialVersionUID = 1L;
	
	private String title;
	
	private String description;
	
	private String image;
	
	@DateTimeFormat(iso=ISO.DATE)
	private Date issueDate;
	
	private String issuer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	
	
}
