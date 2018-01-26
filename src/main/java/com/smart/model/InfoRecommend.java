package com.smart.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.smart.consts.InfoRecommendType;

/**
 * 资讯推荐
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "InfoRecommend") 
public class InfoRecommend extends BaseEntity<InfoRecommend>{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 推荐分类
	 */
	private InfoRecommendType type = InfoRecommendType.home1;

	/**
	 * 被推荐的资讯
	 */
	@ManyToOne
	@JoinColumn(name = "info_id")
	private Info info;

	public InfoRecommendType getType() {
		return type;
	}

	public void setType(InfoRecommendType type) {
		this.type = type;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	
}
