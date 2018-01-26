package com.smart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.smart.consts.DocType;

/**
 * 文档
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "t_doc") 
public class Doc extends BaseEntity<Doc>{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 业务key
	 */
	private String code;
	
	/**
	 * 内容<br />
	 * 使用text类型,最长65535
	 */
	@Type(type="text") 
	@Column(nullable=true)
	private String content;
	
	/**
	 * 文档类型
	 */
	@Enumerated(EnumType.STRING)
	private DocType type;
	/**
	 * 作者
	 */
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DocType getType() {
		return type;
	}

	public void setType(DocType type) {
		this.type = type;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	public String getContentUnEscaped(){
		return content.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
	}
	
	/**
	 * Long型到js端会被截取,故此处转化成String
	 */
	public String getIdStr(){
		return id + "";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
