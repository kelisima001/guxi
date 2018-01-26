package com.smart.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 资讯标签
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "InfoTag") 
public class InfoTag extends BaseEntity<InfoTag>{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "infoId")
	private Info info;
	
	@ManyToOne
	@JoinColumn(name = "tagId")
	private Tag tag;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
		
}
