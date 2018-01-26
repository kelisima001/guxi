package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Honor;

@Controller
public class HonorController extends BaseController{
	@RequestMapping(value = "admin/honor/list")
	public String listHonor(PageRequest pageRequest, Model model){
		Page<Honor> page = honorService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/honor/list";
	}
	
	@RequestMapping(value = "admin/honor/edit", method=RequestMethod.GET)
	public String preEditHonor(Long id, Model model) {
		if(id!=null){
			Honor honor = honorService.findOne(id);
			model.addAttribute("obj", honor);
		}
		return "admin/honor/edit";
	}
	
	@RequestMapping(value = "admin/honor/edit", method=RequestMethod.POST)
	public String editHonor(Honor form, Model model, RedirectAttributes ra) {
		honorService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/honor/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteHonor(Long id) {
		honorService.delete(id);
		return "OK";
	}
	

}
