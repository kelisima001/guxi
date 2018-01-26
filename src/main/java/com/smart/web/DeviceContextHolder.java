package com.smart.web;

public class DeviceContextHolder {
	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();  
	
	public static void setDeviceType(String type){
		threadLocal.set(type);
	}
	
	public static String getDeviceType(){
		return threadLocal.get();
	}
	
	public static void clean(){
		threadLocal.remove();
	}
}
