package com.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.SeoPrice;

@Controller
public class SeoPriceController extends BaseController{
	@RequestMapping(value = "admin/seoPrice/list")
	public String listSeoPrice(PageRequest pageRequest, Model model){
		Page<SeoPrice> page = seoPriceService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/seoPrice/list";
	}
	
	@RequestMapping(value = "admin/seoPrice/edit", method=RequestMethod.GET)
	public String preEditSeoPrice(Long id, Model model) {
		if(id!=null){
			SeoPrice seoPrice = seoPriceService.findOne(id);
			model.addAttribute("obj", seoPrice);
		}
		return "admin/seoPrice/edit";
	}
	
	@RequestMapping(value = "admin/seoPrice/edit", method=RequestMethod.POST)
	public String editSeoPrice(SeoPrice form, Model model, RedirectAttributes ra) {
		seoPriceService.save(form);
		model.addAttribute("obj", form);
		setSuccessMsg(ra);
		return "redirect:edit?id=" + form.getId();
	}
	
	@RequestMapping(value = "admin/seoPrice/delete", method=RequestMethod.GET)
	public @ResponseBody String deleteSeoPrice(Long id) {
		seoPriceService.delete(id);
		return "OK";
	}
	

}
