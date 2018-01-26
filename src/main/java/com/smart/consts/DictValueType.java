package com.smart.consts;

import com.smart.util.ReflectionUtils;

/**
 * 字典值类型
 * 
 * @author Sunxin
 *
 */
public enum DictValueType {
	string("默认"), date("日期"), richText("富文本");
	String description;
	
	public String getDescription() {
		return description;
	}

	DictValueType(String description) {
		this.description = description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clz = Class.forName("com.smart.consts.DictValueType");
		Object[] objs = clz.getEnumConstants();
		for(Object o : objs) {
			System.out.println(o);
			System.out.println(ReflectionUtils.invokeGetterMethod(o, "description"));
		}
	}
	
	
	
}


