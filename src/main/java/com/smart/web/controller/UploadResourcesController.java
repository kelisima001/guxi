package com.smart.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.smart.consts.AppConfig;
import com.smart.model.FileHolder;
import com.smart.util.IOUtil;
import com.smart.util.ImageUtil;
import com.smart.util.RegexUtil;

import jodd.io.FileUtil;
import jodd.util.StringUtil;

/**
 * 上传目录内容管理控制器
 * 
 * @author Sunxin
 *
 */
@Controller
public class UploadResourcesController extends BaseController {
	/**
	 * 上传路径
	 */
	private static final String UPLOAD_PATH = AppConfig.CONTEXT_PATH + File.separator + "upload" + File.separator;
	private static final File UPLOAD_FOLDER = new File(UPLOAD_PATH);
	
	/**
	 * 上传备份路径
	 */
	private static final String UPLOAD_BACKUP_PATH = AppConfig.CONTEXT_PATH + File.separator + "uploadBackup" + File.separator;
	
	private static final String IMAGE_FILE_EXT_REGEX = "jpg|png|gif|ico";
	//private static final Pattern IMAGE_EXT_PATTERN = Pattern.compile(IMAGE_FILE_EXT_PATTERN);
	/**
	 * 列表页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "admin/upload/list")
	public String index(Model model) {
		String[] fileNames = UPLOAD_FOLDER.list();
		List<FileHolder> list = new ArrayList<FileHolder>();
		for(String name : fileNames) {
			FileHolder holder = new FileHolder();
			holder.setName(name);
			holder.setPath("upload/" + name);
			if(isImageFile(name)) {
				holder.setImage(true);
				int[] dim = new int[]{0, 0};
				try{ 
					dim = ImageUtil.getImageDim(new File(UPLOAD_PATH + name));
				}
				catch(Exception e) {
					
				}
				holder.setWidth(dim[0]);
				holder.setHeight(dim[1]);
			}
			list.add(holder);
			
		}
		model.addAttribute("files", list);
		return "admin/upload/list";
	}
	
	@RequestMapping(value = "admin/upload/download")
	public void download(String name, HttpServletResponse response) throws IOException {
		if(StringUtil.isEmpty(name)) {
			return;
		}
		// 防止任意文件下载
		if(name.contains("..") || name.contains("/")) {
			return;
		}
		File f = new File(UPLOAD_PATH + name);
		response.addHeader("Content-Disposition", "attachment;filename=" + name);
        response.addHeader("Content-Length", "" + f.length());
        IOUtil.copy(f, response.getOutputStream());

	}
	
	@RequestMapping(value = "admin/upload/replace")
	public @ResponseBody String replace(String name, MultipartFile file, HttpServletResponse response) throws IOException {
		String uploadFileName = file.getOriginalFilename().toLowerCase();
		String uploadFileNameExt = super.getFileNameExtension(uploadFileName).toLowerCase();
		String origFileNameExt = super.getFileNameExtension(name);
		if(!uploadFileNameExt.equals(origFileNameExt)) {
			return "BAD";
		}
		File inUpload = new File(UPLOAD_PATH + name);
		File inBackup = new File(UPLOAD_BACKUP_PATH + name + "." + (new Date()).getTime());
		FileUtil.copy(inUpload, inBackup);
		boolean res = inUpload.delete();
		file.transferTo(inUpload);
		return "OK";

	}
	
	private boolean isImageFile(String fileName) {
		String ext = super.getFileNameExtension(fileName);
		if("".equals(ext)) {
			return false;
		}
		return RegexUtil.match(IMAGE_FILE_EXT_REGEX, ext);
	}
	
	public static void main(String[] args) {
		System.out.println(RegexUtil.match(IMAGE_FILE_EXT_REGEX, "gdif"));
	}
	
}
