package com.smart.consts;

public enum ProductType {
	
	highTech("高新科技"), carTrade("汽车贸易"), chip("超级薯条"), chicken("鸡排炸鸡"), tea("奶茶产品"), fastfood("经典小吃");
	
	String description;

	ProductType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
