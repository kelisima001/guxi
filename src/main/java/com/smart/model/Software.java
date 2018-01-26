package com.smart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 软件下载
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "Software") 
public class Software extends BaseEntity<Software>{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 图片
	 */
	private String image;
	
	/**
	 * 简单介绍
	 */
	private String shortDescription;
	
	/**
	 * 下载url
	 */
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 详细介绍, 富文本
	 */
	@Type(type="text")
	@Column(nullable=true)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptionUnEscaped(){
		return description.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
	}
	
}
