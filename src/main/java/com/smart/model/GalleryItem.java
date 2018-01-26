package com.smart.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 图片轮播项
 * 
 * @author Sunxin
 *
 */

@Entity
@Table(name = "galleryItem")
public class GalleryItem extends BaseEntity<GalleryItem> {
	private static final long serialVersionUID = 1L;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 文字
	 */
	private String text;
	/**
	 * 图片
	 */
	private String image;
	/**
	 * 超链接
	 */
	private String url;

	/**
	 * 所属相册/轮播
	 */
	@ManyToOne
	@JoinColumn(name = "gallery_id")
	private Gallery gallery;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
