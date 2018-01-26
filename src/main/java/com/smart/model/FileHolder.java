package com.smart.model;

/**
 * 文件资源描述
 * 
 * @author Sunxin
 *
 */
public class FileHolder {
	/**
	 * 文件名
	 */
	private String name;
	/**
	 * 可访问的路径
	 */
	private String path;
	/**
	 * 文件绝对路径
	 */
	private String absPath;
	/**
	 * 文件类型描述
	 */
	private String type;
	
	/**
	 * 是否图片
	 */
	private boolean image = false;
	/**
	 * 宽度, 仅限图片
	 */
	private int width;
	/**
	 * 高度, 仅限图片
	 */
	private int height;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getAbsPath() {
		return absPath;
	}
	public void setAbsPath(String absPath) {
		this.absPath = absPath;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	
}
