package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.InjectInfo;

@Controller
public class InjectInfoController extends BaseController{
	@RequestMapping(value = "admin/injectInfo/list")
	public String listInjectInfo(PageRequest pageRequest, Model model){
		Page<InjectInfo> page = injectInfoService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/injectInfo/list";
	}
	
	@RequestMapping(value = "admin/injectInfo/edit", method=RequestMethod.GET)
	public String preEditInjectInfo(Long id, Model model) {
		if(id!=null){
			InjectInfo injectInfo = injectInfoService.findOne(id);
			model.addAttribute("obj", injectInfo);
		}
		return "admin/injectInfo/edit";
	}
	
	@RequestMapping(value = "admin/injectInfo/edit", method=RequestMethod.POST)
	public String editInjectInfo(InjectInfo form, Model model, RedirectAttributes ra) {
		injectInfoService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/injectInfo/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteInjectInfo(Long id) {
		injectInfoService.delete(id);
		return "OK";
	}
	
	@RequestMapping(value = "injectInfo/add")
	public @ResponseBody String addInjectInfo(InjectInfo info, Model model){
		injectInfoService.save(info);
		return "";
	}

}
