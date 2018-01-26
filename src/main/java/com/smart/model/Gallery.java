package com.smart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 相册/图片轮播
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "gallery") 
public class Gallery extends BaseEntity<Gallery>{
	private static final long serialVersionUID = 1L;
	/**
	 * 编号,对于一些系统级的轮播可以设置编号, 以便于通过编号来检索
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 播放时间间隔, 以秒为单位, interval看起来是mysql的关键字
	 */
	private Integer playInterval = 0;
	/**
	 * 轮播项列表, 不需要存储
	 */
	@Transient
	private List<GalleryItem> items;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPlayInterval() {
		return playInterval;
	}
	public void setPlayInterval(Integer playInterval) {
		this.playInterval = playInterval;
	}
	public List<GalleryItem> getItems() {
		return items;
	}
	public void setItems(List<GalleryItem> items) {
		this.items = items;
	}
	
}
