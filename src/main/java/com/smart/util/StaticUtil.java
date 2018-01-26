package com.smart.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 静态类的工具
 * 
 * @author Xin.Sun
 *
 */
public class StaticUtil {
	/**
	 * 获得静态域的名称和值字符串 方便调试
	 */
	public static String toStaticFieldString(Class<?> clz){
		Field[] fields = clz.getDeclaredFields();
		String result = "[\n";
		for(Field field : fields){
			int mods = field.getModifiers();
			if(Modifier.isStatic(mods)){
				result += field.getName() + ":";
				try {
					result += field.get(null) + "\n";
				} catch (Exception e) {
					result += "null\n";
				}
			}
		}
		result += "]";
		return result;
	}
}
