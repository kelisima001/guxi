package com.smart.web.controller;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.consts.AppConfig;
import com.smart.model.User;
import com.smart.service.ServiceSupport;
import com.smart.util.BeanUtil;
import com.smart.util.IOUtil;
import com.smart.web.DeviceContextHolder;

/**
 * 控制器基类
 * 
 * @author Sunxin
 *
 */
public abstract class BaseController extends ServiceSupport{
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 验证码检验
	 * @param session
	 * @param code
	 * @return
	 */
	protected boolean checkValidateCode(HttpServletRequest req, String code){
		return captchaService.verifyCaptcha(req, code);
	}
	
	public User getCurrentUser(HttpSession session){
		return (User) session.getAttribute("user");
	}
	
	/**
	 * 获取当前用户
	 * 
	 * @return null if not exists
	 */
	public User getCurrentUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			Object principal = auth.getPrincipal();
			if(principal instanceof User){
				return (User)principal;
			}
		}
		
		return null;
	}
	
	/**
	 * 快捷设置操作成功的消息
	 * @param model
	 */
	public void setSuccessMsg(Model model){
		model.addAttribute("msg", "操作成功");
		model.addAttribute("success", true);
	}
	
	/**
	 * 快捷设置操作成功的消息, 放到重定向属性里
	 * @param model
	 */
	public void setSuccessMsg(RedirectAttributes ra){
		ra.addFlashAttribute("msg", "操作成功");
		ra.addFlashAttribute("success", true);
	}
	
	/**
	 * 快捷设置操作成功的消息, 放到重定向属性里
	 * @param model
	 */
	public void setSuccessMsg(RedirectAttributes ra, String msg){
		ra.addFlashAttribute("msg", msg);
		ra.addFlashAttribute("success", true);
	}
	
	/**
	 * 快捷设置操作失败的消息
	 * @param model
	 * @param msg
	 */
	public void setErrorMsg(Model model, String msg){
		model.addAttribute("msg", msg==null ? "操作失败" : msg);
		model.addAttribute("success", false);
	}
	
	/**
	 * 处理单个上传文件域
	 * 
	 * @param file 上传的附件
	 * @param obj 作用的对象
	 * @param fieldName 作用的对象要更新的域
	 */
	protected void handleUploadField(MultipartFile file, Object obj, String fieldName){
		if(file!=null && file.getSize()!=0){
			String fileName = (new Date()).getTime() + "";
			String origFileName = file.getOriginalFilename();
			String extName = origFileName.substring(origFileName.lastIndexOf("."));
			File dest = new File(AppConfig.CONTEXT_PATH + "/upload/" + fileName + extName);
			System.out.println(dest.getAbsolutePath());
			try{
				IOUtil.createFolderForFileIfNotExist(dest);
				dest.createNewFile();
				file.transferTo(dest);
				Method method = BeanUtil.getWriteMethod(obj.getClass(), fieldName);
				BeanUtil.invokeMethod(obj, method, "upload/" + fileName + extName);				
			}
			catch(Exception ex){
				logger.error("Failed to upload file", ex);
				logger.error("Dest: " + dest.getAbsolutePath());
			}
		}
	}
	
	/**
	 * 处理多文件上传域
	 * 
	 * @param request
	 * @return
	 */
	protected List<String> handleMultipleUploadFields(HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		List<String> result = new ArrayList<String>();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile mf = entity.getValue();
			String fileName = mf.getOriginalFilename();
			String extension = getFileNameExtension(fileName);
			// 文件名采用时间戳 + 随机字符串 的方式, 防止在多文件上传的时候时间戳重复;
			String newFileName = (new Date()).getTime() + generateRandomString() + extension;
			File file = new File(AppConfig.CONTEXT_PATH + File.separator + "upload" + File.separator + newFileName);
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			result.add("upload/" + newFileName);
			//System.out.println(file.getAbsolutePath());
			//System.out.println();
		}
		return result;
	}
	
	/**
	 * 获取文件名后缀
	 * 
	 * @param origName
	 * @return
	 */
	protected String getFileNameExtension(String origName){
		if(origName.indexOf(".")==-1){
			return "";
		}
		return origName.substring(origName.indexOf(".") + 1);
	}

	/**
	 * 生成随机字符串
	 * @return 字符串
	 */
	protected String generateRandomString(){
		String s = UUID.randomUUID().toString();
		s =  s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
		return s.substring(0, 12);
	}
	/**
	 * 添加request scope属性
	 * 
	 * @param key
	 * @param val
	 */
	protected void addRequestAttribute(String key, Object val) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute(key, val);
	}
	
	/**
	 * PC移动端视图切换
	 * 
	 * @param viewName
	 * @return
	 */
	protected String view(String viewName){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String path = uri.replaceFirst(ctxPath, "");
		if(path.startsWith("/")){
			path = path.replaceFirst("/", "");
		}
		//System.out.println(ctxPath); // like /xxx
		//System.out.println(uri); // like /xxx/index
		//System.out.println(path); 
		String[] paths = path.split("/");
		String menu1 = paths[0];
		request.setAttribute("menu1", menu1);
		if(paths.length>=2){
			String menu2 = paths[1];
			request.setAttribute("menu2", menu2);
		}
		String type = DeviceContextHolder.getDeviceType();
		if("mobile".equals(type)){
			return viewName + "1";
		}
		return viewName;
	}
	
	
	
}
