package com.smart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 产品
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "Product") 
public class Product extends BaseEntity<Product>{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 长名
	 */
	private String longName;
	
	/**
	 * 短名
	 */
	private String shortName;
	
	/**
	 *  产品类别
	 */
	@ManyToOne
	@JoinColumn(name = "select_item_id")
	private SelectItem type;
	
	/**
	 * 短介绍
	 */
	private String shortDescription;
	
	/**
	 * 长介绍
	 */
	@Type(type="text") 
	@Column(nullable=true)
	private String description;

	/**
	 * 主图
	 */
	private String image;
	
	/**
	 * 图片组,以|分隔
	 */
	private String images;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public SelectItem getType() {
		return type;
	}

	public void setType(SelectItem type) {
		this.type = type;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
	public String getDescriptionUnEscaped(){
		if(description==null) {
			return "";
		}
		return description.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
	}
}
