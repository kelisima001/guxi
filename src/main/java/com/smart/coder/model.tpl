package com.smart.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "{name}") 
public class {name} extends BaseEntity<{name}>{
	private static final long serialVersionUID = 1L;
	
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
