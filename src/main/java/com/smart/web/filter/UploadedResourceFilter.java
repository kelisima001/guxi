package com.smart.web.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.smart.util.AppUtil;

public class UploadedResourceFilter implements Filter{
	
	public  static final Logger logger = Logger.getLogger("web");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		
		if(isUploadPath(uri)){
			handleUploadedResource(res, uri);
			return;
		}
        chain.doFilter(new RequestWrapper(req), response);
	}

	private void handleUploadedResource(HttpServletResponse res, String uri)
			throws IOException, FileNotFoundException {
		String uriWithoutParamter = uri.split("\\?")[0];
		String fileName = uriWithoutParamter.substring(uriWithoutParamter.lastIndexOf("/")+1);
		String uploadImageFolder = AppUtil.getUploadedImageFolder();
		File imageFile = new File(uploadImageFolder + fileName);
		if(!imageFile.exists()){
			res.sendError(404, "can't find uploaded resource " + uri);
		}
		else{
			FileInputStream in = new FileInputStream(imageFile);
			byte[] buffer = new byte[4096];
			int lengthRead = in.read(buffer);
			while(lengthRead!=-1){
				res.getOutputStream().write(buffer, 0, lengthRead);
				lengthRead = in.read(buffer);
			}
			in.close();
			res.getOutputStream().flush();
		}
		return;
	}
	
	private boolean isUploadPath(String uri){
		if(uri.contains("/uploadedImage/")){
			return true;
		}
		return false;
	}
	
	@Override
	public void destroy() {
		
	}
}
