package com.smart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_selecttype")
public class SelectType extends BaseEntity<SelectType> {
	private static final long serialVersionUID = -7376834941589252258L;
	
	private String name;
	
	private String code;
	
	private String description;
	
	@Transient
	private List<SelectItem> items;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SelectItem> getItems() {
		return items;
	}

	public void setItems(List<SelectItem> items) {
		this.items = items;
	}
	

}