package com.smart.util;

import java.io.File;
import java.util.Properties;

public class AppUtil {
	private static Properties props = new Properties();

	private static String ROOT_DIRECTORY = "";

	static {
		try {
			props.load(AppUtil.class.getClassLoader().getResourceAsStream("/config.properties"));

			if (System.getProperty("os.name").toLowerCase().contains("win")) {
				ROOT_DIRECTORY = "C:" + File.separator + "smart" + File.separator;
			} else {
				ROOT_DIRECTORY = File.separator + "smart" + File.separator;
			}

		} catch (Exception e) {
			//TODO log
		}
	}

	public static String getProperty(String key, String def) {
		return props.getProperty(key, def);
	}

	public static void setProperty(String key, String val) {
		props.setProperty(key, val);
	}

	public static String getUploadedImageFolder(){
		String os = System.getProperty("os.name").toLowerCase();
		if(os.toLowerCase().startsWith("windows")){
			return "c:/smart/upload/";
		}
		else{
			return "/smart/images/upload/";
		}
	}
	
	public static boolean isEmailValidationRequired(){
		String needEmailValidation = System.getProperty("user.needEmailValidation", "1");
		if("1".equals(needEmailValidation)){
			return true;
		}
		return false;
	}
	
	public static Long getSampleInvitationId(){
		return 100L;
	}
	
}
