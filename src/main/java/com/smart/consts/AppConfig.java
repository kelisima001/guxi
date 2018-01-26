package com.smart.consts;

import com.smart.util.StaticUtil;

/**
 * 应用程序配置
 * 
 * @author Xin.Sun
 *
 */
public class AppConfig {
	public static String CONTEXT_PATH = "";
	
	/**
	 * 获得AppConfig调试字符串
	 * @return
	 */
	public static String getAppConfigString(){
		return StaticUtil.toStaticFieldString(AppConfig.class);
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{
		System.out.println(getAppConfigString());
	}
}
