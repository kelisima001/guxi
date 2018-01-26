package com.smart.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * 
 * @author Sunxin
 *
 */
public class RegexUtil {
	
	/**
	 * 是否匹配
	 * @param regex 正则表达式
	 * @param target 目标字符串
	 * @return
	 */
	public static boolean match(String regex, String target) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(RegexUtil.match("gif|jpg|png", "gif"));
		System.out.println(RegexUtil.match("gif|jpg|png", "xxx"));
	}
}
