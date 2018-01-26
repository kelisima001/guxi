package com.smart.service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.consts.AppConfig;

@Service
public class ImageServiceImpl implements ImageService {

	@Override
	public List<String> listImagesUnderFolder(String folderNameUnderUpload) {
		List<String> list = new ArrayList<String>();
		String path = AppConfig.CONTEXT_PATH + File.separator + "upload" + File.separator + folderNameUnderUpload;
		File f = new File(path);
		if(!f.exists()){
			return list;
		}
		String[] names = f.list(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				return true;
			}
		});
		if(names!=null && names.length!=0){
			list.addAll(Arrays.asList(names));
		}
		return list;
	}
}
