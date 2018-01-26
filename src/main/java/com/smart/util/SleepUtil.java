package com.smart.util;

/**
 * Sleep工具类。
 * 
 * @author Sunxin
 */
public class SleepUtil {
	public static void sleep(long ts) {
		try {
			Thread.sleep(ts);
		} catch (InterruptedException e) {
			
		}
	}
}
