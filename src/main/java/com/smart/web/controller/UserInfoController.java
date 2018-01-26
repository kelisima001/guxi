package com.smart.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.UserInfo;

@Controller
public class UserInfoController extends BaseController{
	@RequestMapping(value = "admin/userInfo/list")
	public String listUserInfo(PageRequest pageRequest, Model model){
		Page<UserInfo> page = userInfoService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/userInfo/list";
	}
	
	@RequestMapping(value = "admin/userInfo/edit", method=RequestMethod.GET)
	public String preEditUserInfo(Long id, Model model) {
		if(id!=null){
			UserInfo userInfo = userInfoService.findOne(id);
			model.addAttribute("obj", userInfo);
		}
		return "admin/userInfo/edit";
	}
	
	@RequestMapping(value = "admin/userInfo/edit", method=RequestMethod.POST)
	public String editUserInfo(UserInfo form, Model model) {
		userInfoService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(model);
		return "admin/userInfo/edit";
	}
	
	@RequestMapping(value = "userInfo/add")
	public @ResponseBody String deleteUserInfo(HttpServletRequest req, UserInfo userInfo, String code) {
		userInfoService.save(userInfo);
		return "OK";
	}
	

}
