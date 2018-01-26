package com.smart.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Software;
import com.smart.model.SoftwareCond;

@Controller
public class SoftwareController extends BaseController{
	@RequestMapping(value = "admin/software/list")
	public String listSoftware(PageRequest pageRequest, Model model){
		Page<Software> page = softwareService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/software/list";
	}
	
	@RequestMapping(value = "admin/software/edit", method=RequestMethod.GET)
	public String preEditSoftware(Long id, Model model) {
		if(id!=null){
			Software software = softwareService.findOne(id);
			model.addAttribute("obj", software);
		}
		return "admin/software/edit";
	}
	
	@RequestMapping(value = "admin/software/edit", method=RequestMethod.POST)
	public String editSoftware(Software form, Model model, RedirectAttributes ra) {
		softwareService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/software/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteSoftware(Long id) {
		softwareService.delete(id);
		return "OK";
	}
	
	@RequestMapping(value = "software/list.html")
	public String list(Model model) {
		SoftwareCond softwareCond = new SoftwareCond();
		softwareCond.addOrderByAsc("sort");
		List<Software> softwares = softwareService.find(softwareCond);
		model.addAttribute("softwares", softwares);
		return "software/list";
	}
	

	@RequestMapping(value = "software/{id}.html")
	public String list(Model model, @PathVariable Long id) {
		
		Software software = softwareService.findOne(id);
		model.addAttribute("software", software);
		return "software/view";
	}
	
}
