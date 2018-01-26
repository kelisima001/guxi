package com.smart.service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.consts.AppConfig;
import com.smart.consts.DictModules;
import com.smart.util.ArrayUtil;

@Service
public class FileServiceImpl implements FileService{

	private static String VALID_IMAGE_FILE_REGEX = "^[1234567890_a-zA-Z\\-]*$";
	private static Pattern VALID_IMAGE_FILE_PATTERN = Pattern.compile(VALID_IMAGE_FILE_REGEX);
	@Autowired
	private DictService dictService;
	
	@Override
	public List<String> listImageUnderUploadFolder() {
		String uploadRoot = dictService.getDictValue(DictModules.MOD_SYS, "upload.root.dir");
		String path = AppConfig.CONTEXT_PATH + uploadRoot;
		System.out.println(path);
		File uploadFolder = new File(path);
		if(uploadFolder.exists()){
			String[] fileNames = uploadFolder.list(new FilenameFilter(){
				@Override
				public boolean accept(File dir, String name) {
					String[] parts = name.split("\\.");
					if(parts.length!=2){
						return false;
					}
					Matcher matcher = VALID_IMAGE_FILE_PATTERN.matcher(parts[0]);
					if(!matcher.find()){
						return false;
					}
					parts[1] = parts[1].toLowerCase();
					if(!parts[1].equals("jpg") && !parts[1].equals("png") && !parts[1].equals("gif")){
						return false;
					}
					return true;
				}
				
			});
			return ArrayUtil.asList(fileNames);
		}
		return null;
	}

	public static void main(String[] args){
		Matcher matcher = VALID_IMAGE_FILE_PATTERN.matcher("23_45-6DFGHJ");
		if(matcher.find()){
			System.out.println("match"); 
		}
	}
}
