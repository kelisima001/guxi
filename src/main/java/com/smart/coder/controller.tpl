package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.{name};

@Controller
public class {name}Controller extends BaseController{
	@RequestMapping(value = "admin/{varName}/list")
	public String list{name}(PageRequest pageRequest, Model model){
		Page<{name}> page = {varName}Service.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/{varName}/list";
	}
	
	@RequestMapping(value = "admin/{varName}/edit", method=RequestMethod.GET)
	public String preEdit{name}(Long id, Model model) {
		if(id!=null){
			{name} {varName} = {varName}Service.findOne(id);
			model.addAttribute("obj", {varName});
		}
		return "admin/{varName}/edit";
	}
	
	@RequestMapping(value = "admin/{varName}/edit", method=RequestMethod.POST)
	public String edit{name}({name} form, Model model, RedirectAttributes ra) {
		{varName}Service.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/{varName}/delete", method=RequestMethod.GET)
	public @ResponseBody String delete{name}(Long id) {
		{varName}Service.delete(id);
		return "OK";
	}
	

}
