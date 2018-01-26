package com.smart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

/**
 * 通用信息
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "Info") 
public class Info extends BaseEntity<Info>{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标题
	 */
	@Column(length=2048)
	private String title;
	/**
	 * 概要
	 */
	@Column(length=2048)
	private String abstraction;
	/**
	 * 内容
	 */
	@Type(type="text") 
	@Column(nullable=true)
	private String content;
	/**
	 * 来源
	 */
	private String source = "";
	/**
	 * 作者
	 */
	private String author = "";
	
	/**
	 * 类型
	 */
	@ManyToOne
	@JoinColumn(name = "type_item_id")
	private SelectItem type;
	
	/**
	 * 图片名称
	 */
	private String image;
	
	@Transient
	protected String timeCreatedStr2;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstraction() {
		return abstraction;
	}
	public void setAbstraction(String abstraction) {
		this.abstraction = abstraction;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public SelectItem getType() {
		return type;
	}
	public void setType(SelectItem type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTimeCreatedStr2() {
		return timeCreatedStr2;
	}
	public void setTimeCreatedStr2(String timeCreatedStr2) {
		this.timeCreatedStr2 = timeCreatedStr2;
	}
	public String getContentUnEscaped(){
		if(content==null) {
			return "";
		}
		return content.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
	}
	
}
