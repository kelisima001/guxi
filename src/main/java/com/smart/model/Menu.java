package com.smart.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 菜单类
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "Menu") 
public class Menu extends BaseEntity<Menu>{
	
	private static final long serialVersionUID = 1L;
	public static final String ROOT_MENU_CODE = "ROOT";
	/**
	 * 菜单名, 也是菜单项的文字; 
	 */
	private String name;

	/**
	 * 菜单key
	 */
	private String code;
	
	/**
	 * 菜单超链接URL
	 */
	private String url;
	
	@ManyToOne
    @JoinColumn(name="parent_id")
	private Menu parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
	
	
}
