package com.smart.web.controller;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.smart.consts.AppConfig;
import com.smart.util.IOUtil;

@Controller
public class ImageController extends BaseController{
	
	
	
	@RequestMapping(value = "/admin/uploadImage", method = RequestMethod.GET)
	public @ResponseBody String getConfig(String action){
		if("config".equals(action)){
			InputStream in = ImageController.class.getClassLoader().getResourceAsStream("/ueditorConfig.json");
			String config = "{}";
			try {
				 config = com.smart.util.IOUtil.toString(in);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return config;
		}
		return "{'msg': 'unknown action " + action + "'}";
	}
	@RequestMapping(value = "/admin/uploadImage", method = RequestMethod.POST)
	public @ResponseBody String uploadImage(String action, String name, String type, String size, MultipartFile upfile){
		if("uploadimage".equals(action)){
			return handleUploadImage(upfile);
		}
		return "{'msg': 'unknown action " + action + "'}";
	}

	private String handleUploadImage(MultipartFile file) {
		if(file==null || file.getSize()==0){
			return "{'state':'FAILURE'}";
		}
		String fileName = (new Date()).getTime() + "";
		String origFileName = file.getOriginalFilename();
		String extName = origFileName.substring(origFileName.lastIndexOf("."));
		File dest = new File(AppConfig.CONTEXT_PATH + "/upload/" + fileName + extName);
		System.out.println(dest.getAbsolutePath());
		fileName = "upload/" + fileName + extName;
		try{
			IOUtil.createFolderForFileIfNotExist(dest);
			dest.createNewFile();
			file.transferTo(dest);
			return "{\"state\": \"SUCCESS\",\"title\": \""
			+ fileName + extName + "\",\"original\": \""
			+ "T.jpg" + "\",\"type\": \""
			+ extName + "\",\"url\": \""
			+ fileName + "\",\"size\": \"" 
			+ file.getSize() + "\"}";
		}
		catch(Exception ex){
			logger.error("Failed to upload file", ex);
			logger.error("Dest: " + dest.getAbsolutePath());
			return "{'state':'FAILURE'}";
		}
	}
	
}
