package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Tag;

@Controller
public class TagController extends BaseController{
	@RequestMapping(value = "admin/tag/list")
	public String listTag(PageRequest pageRequest, Model model){
		Page<Tag> page = tagService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/tag/list";
	}
	
	@RequestMapping(value = "admin/tag/edit", method=RequestMethod.GET)
	public String preEditTag(Long id, Model model) {
		if(id!=null){
			Tag tag = tagService.findOne(id);
			model.addAttribute("obj", tag);
		}
		return "admin/tag/edit";
	}
	
	@RequestMapping(value = "admin/tag/edit", method=RequestMethod.POST)
	public String editTag(Tag form, Model model, RedirectAttributes ra) {
		tagService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/tag/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteTag(Long id) {
		tagService.delete(id);
		return "OK";
	}
	
}
