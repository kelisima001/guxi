package com.smart.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;

import com.smart.consts.Status;

@Entity
@Table(name = "SelectItem")
public class SelectItem extends BaseEntity<SelectItem>{
	
	private static final long serialVersionUID = 2323948837654520750L;

	private String name;

	@ManyToOne
	@JoinColumn(name = "select_type_id")
	private SelectType selectType;
	
	@ManyToOne
	@ForeignKey(name = "none")
	@JoinColumn(name = "parent_id")
	@Fetch(FetchMode.JOIN)
	private SelectItem parent;

	private String code;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.active;

	private String color;

	private String image;

	private String description;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SelectType getSelectType() {
		return selectType;
	}

	public void setSelectType(SelectType selectType) {
		this.selectType = selectType;
	}

	public SelectItem getParent() {
		return parent;
	}

	public void setParent(SelectItem parent) {
		this.parent = parent;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
