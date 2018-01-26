package com.smart.web.controller;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.smart.consts.AppConfig;
import com.smart.util.JsonUtil;

@Controller
public class UploadController extends BaseController{
	
	/**
	 * 上传的资源文件暂只考虑数字, 字母, 中划线, 下划线;
	 */
	private static final String IMG_FILE_NAME_CHARS = "^[0-9a-zA-Z_\\-]*\\.(jpg|gif|png)$";
	private static final Pattern IMG_FILE_PATTERN = Pattern.compile(IMG_FILE_NAME_CHARS);
	
	/**
	 * 
	 * @param path 以上传目录upload为基础的当前路径, 不包含upload本身;
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "admin/upload/list", method = RequestMethod.POST)
	public @ResponseBody String list(String path, Model model){
		if(path==null){
			path = "/";
		}
		else if(!path.endsWith("/")){
			path = path + "/";
		}
		String folder = AppConfig.CONTEXT_PATH + File.separator + "upload" + File.separator + path;
		File file = new File(folder);
		
		String [] fileNames = file.list(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				return IMG_FILE_PATTERN.matcher(name).find();
			}
			
		});
		return JsonUtil.array2json(fileNames);
	}
	
	@RequestMapping(value = "admin/upload/doUpload", method = RequestMethod.POST)
	public @ResponseBody String uploadCases(HttpServletRequest request, String path, Model model) throws IllegalStateException, IOException{
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		List<String> result = new ArrayList<String>();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile mf = entity.getValue();
			String fileName = mf.getOriginalFilename();
			String extension = getFileNameExtension(fileName);
			// 文件名采用时间戳 + 随机字符串 的方式, 防止在多文件上传的时候时间戳重复;
			String newFileName = (new Date()).getTime() + generateRandomString() + extension;
			File file = new File(AppConfig.CONTEXT_PATH + File.separator + "upload" + File.separator  + File.separator + newFileName);
			mf.transferTo(file);
			result.add(newFileName);
			System.out.println(file.getAbsolutePath());
		}
		return JsonUtil.array2json(result);
	}
	
	public static void main(String[] args){
		//System.out.println("abc.jpg".matches());;
		Pattern pat = Pattern.compile("^[0-9a-zA-Z_\\-]*\\.(jpg|gif|png)$");
		Matcher matcher = pat.matcher("_-abc.png");
		System.out.println(matcher.find());
	}
}
